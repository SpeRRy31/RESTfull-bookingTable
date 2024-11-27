package app.service;

import app.entity.Tables;
import app.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesServices {

    @Autowired
    private TablesRepository tableRepository;

    public List<Tables> getAllTables() {
        return tableRepository.findAll();
    }

    public Tables getTableById(Long id) {
        return tableRepository.findById(id).orElse(null);
    }

    public Tables createTable(Tables table) {
        return tableRepository.save(table);
    }

    public Tables updateTable(Long id, Tables updatedTable) {
        Optional<Tables> existingTable = tableRepository.findById(id);
        if (existingTable.isPresent()) {
            Tables table = existingTable.get();
            table.setSeats(updatedTable.getSeats());
            table.setLocation(updatedTable.getLocation());
            table.setAvailability(updatedTable.isAvailability());
            table.setType(updatedTable.getType());
            table.setMinimumOrder(updatedTable.getMinimumOrder());
            table.setImage(updatedTable.getImage());
            return tableRepository.save(table);
        }
        return null;
    }

    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
