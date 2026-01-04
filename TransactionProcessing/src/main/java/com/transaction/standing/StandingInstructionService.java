package com.transaction.standing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.account.Account;
import com.transaction.account.AccountService;
import com.transaction.transaction.Transaction;
import com.transaction.transaction.TransactionService;

import java.time.LocalDate;
import java.util.List;

/**
 * Service implementation for Standing Instructions
 * Feature 5: Standing Instructions - Auto-transfer on specific dates
 */
@Service
public class StandingInstructionService {

    @Autowired
    private StandingInstructionRepository standingInstructionRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    // Standard CRUD
    public List<StandingInstruction> getAllInstructions() {
        return standingInstructionRepository.findAll();
    }

    public StandingInstruction getInstructionById(Long id) {
        return standingInstructionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Standing instruction not found with id: " + id));
    }

    public StandingInstruction createInstruction(StandingInstruction instruction) {
        instruction.setStatus("ACTIVE");
        instruction.setNextExecution(calculateNextExecution(instruction));
        return standingInstructionRepository.save(instruction);
    }

    public StandingInstruction updateInstruction(Long id, StandingInstruction instructionDetails) {
        StandingInstruction instruction = getInstructionById(id);
        instruction.setAmount(instructionDetails.getAmount());
        instruction.setFrequency(instructionDetails.getFrequency());
        instruction.setExecutionDay(instructionDetails.getExecutionDay());
        instruction.setStatus(instructionDetails.getStatus());
        instruction.setNextExecution(calculateNextExecution(instruction));
        return standingInstructionRepository.save(instruction);
    }

    public void deleteInstruction(Long id) {
        standingInstructionRepository.deleteById(id);
    }

    // Feature 5: Execute Standing Instructions
    public void executeStandingInstructions() {
        LocalDate today = LocalDate.now();
        List<StandingInstruction> dueInstructions = standingInstructionRepository
                .findByStatusAndNextExecutionBefore("ACTIVE", today.plusDays(1));

        for (StandingInstruction instruction : dueInstructions) {
            processInstruction(instruction);
        }
    }

    private void processInstruction(StandingInstruction instruction) {
        try {
            // Create transaction
            Transaction transaction = new Transaction();
            transaction.setTransactionType("TRANSFER");
            transaction.setFromAccount(instruction.getFromAccount());
            transaction.setToAccount(instruction.getToAccount());
            transaction.setAmount(instruction.getAmount());
            transaction.setCurrency(instruction.getFromAccount().getCurrency());
            transaction.setDescription("Standing Instruction: " + instruction.getDescription());

            transactionService.processTransaction(transaction);

            // Update instruction
            instruction.setLastExecuted(LocalDate.now());
            instruction.setNextExecution(calculateNextExecution(instruction));
            standingInstructionRepository.save(instruction);

            System.out.println("✅ Standing instruction executed: " + instruction.getId());
        } catch (Exception e) {
            System.err.println(
                    "❌ Failed to execute standing instruction: " + instruction.getId() + " - " + e.getMessage());
        }
    }

    private LocalDate calculateNextExecution(StandingInstruction instruction) {
        LocalDate current = instruction.getLastExecuted() != null ? instruction.getLastExecuted() : LocalDate.now();

        switch (instruction.getFrequency()) {
            case "DAILY":
                return current.plusDays(1);
            case "WEEKLY":
                return current.plusWeeks(1);
            case "MONTHLY":
                return current.plusMonths(1);
            case "YEARLY":
                return current.plusYears(1);
            default:
                return current.plusDays(1);
        }
    }

    public List<StandingInstruction> getInstructionsByAccount(Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return standingInstructionRepository.findByFromAccount(account);
    }
}
