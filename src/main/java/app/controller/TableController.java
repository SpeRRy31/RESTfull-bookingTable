package app.controller;

import app.dto.TableDTO;
import app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    // Отримати всі столи
    @GetMapping
    public List<TableDTO> getAllTables() {
        return tableService.getAllTables();
    }

    // Отримати стіл за ID
    @GetMapping("/{id}")
    public ResponseEntity<TableDTO> getTableById(@PathVariable Long id) {
        TableDTO table = tableService.getAllTables()
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Table not found"));
        return ResponseEntity.ok(table);
    }

    // Додати новий стіл
    @PostMapping
    public ResponseEntity<TableDTO> createTable(@RequestBody TableDTO tableDTO) {
        TableDTO createdTable = tableService.createTable(tableDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTable);
    }

    // Оновити стіл
    @PutMapping("/{id}")
    public ResponseEntity<TableDTO> updateTable(@PathVariable Long id, @RequestBody TableDTO tableDTO) {
        TableDTO updatedTable = tableService.updateTable(id, tableDTO);
        return ResponseEntity.ok(updatedTable);
    }

    // Видалити стіл
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
