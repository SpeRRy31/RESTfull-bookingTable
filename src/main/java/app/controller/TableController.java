package app.controller;

import app.dto.TableDTO;
import app.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    // Отримати всі столи
    @GetMapping
    public ResponseEntity<List<TableDTO>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTables());
    }

    // Отримати стіл за ID
    @GetMapping("/{id}")
    public ResponseEntity<TableDTO> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableById(id));
    }

    // Додати новий стіл
    @PostMapping
    public ResponseEntity<TableDTO> createTable(@RequestBody TableDTO tableDTO) {
        return ResponseEntity.ok(tableService.createTable(tableDTO));
    }

    // Оновити стіл за ID
    @PutMapping("/{id}")
    public ResponseEntity<TableDTO> updateTable(
            @PathVariable Long id,
            @RequestBody TableDTO tableDTO
    ) {
        return ResponseEntity.ok(tableService.updateTable(id, tableDTO));
    }

    // Видалити стіл за ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
