package app.controller;

import app.entity.Tables;
import app.service.TablesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TablesController {

    @Autowired
    private TablesServices tableService;

    @GetMapping
    public List<Tables> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable Long id) {
        Tables table = tableService.getTableById(id);
        if (table != null) {
            return ResponseEntity.ok(table);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Tables createTable(@RequestBody Tables table) {
        return tableService.createTable(table);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tables> updateTable(@PathVariable Long id, @RequestBody Tables updatedTable) {
        Tables table = tableService.updateTable(id, updatedTable);
        if (table != null) {
            return ResponseEntity.ok(table);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
