package app.service;

import app.dto.TableDTO;
import app.entity.Table;
import app.mapper.TableMapper;
import app.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private TableMapper tableMapper;

    // Отримати список всіх столів
    public List<TableDTO> getAllTables() {
        List<Table> tables = tableRepository.findAll();
        return tables.stream()
                .map(tableMapper::toDto)
                .collect(Collectors.toList());
    }

    // Додати новий стіл
    public TableDTO createTable(TableDTO tableDTO) {
        Table table = tableMapper.toEntity(tableDTO);
        table = tableRepository.save(table);
        return tableMapper.toDto(table);
    }

    // Оновити стіл
    public TableDTO updateTable(Long id, TableDTO tableDTO) {
        Table existingTable = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));
        existingTable.setSeats(tableDTO.getSeats());
        existingTable.setLocation(tableDTO.getLocation());
        existingTable.setAvailability(tableDTO.getAvailability());
        existingTable.setType(tableDTO.getType());
        existingTable.setMinimumOrder(tableDTO.getMinimumOrder());
        existingTable.setImage(tableDTO.getImage());
        existingTable = tableRepository.save(existingTable);
        return tableMapper.toDto(existingTable);
    }

    // Видалити стіл
    public void deleteTable(Long id) {
        tableRepository.deleteById(id);
    }
}
