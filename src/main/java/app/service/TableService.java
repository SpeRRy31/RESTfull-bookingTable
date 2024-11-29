package app.service;

import app.dto.TableDTO;
import app.entity.Table;
import app.mapper.TableMapper;
import app.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository tableRepository;
    private final TableMapper tableMapper;

    public TableService(TableRepository tableRepository, TableMapper tableMapper) {
        this.tableRepository = tableRepository;
        this.tableMapper = tableMapper;
    }

    // Отримати всі столи
    public List<TableDTO> getAllTables() {
        return tableRepository.findAll()
                .stream()
                .map(tableMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Отримати стіл за ID
    public TableDTO getTableById(Long id) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Стіл не знайдено"));
        return tableMapper.toDTO(table);
    }

    // Створити новий стіл
    public TableDTO createTable(TableDTO tableDTO) {
        Table table = tableMapper.toEntity(tableDTO);
        Table savedTable = tableRepository.save(table);
        return tableMapper.toDTO(savedTable);
    }

    // Оновити стіл
    public TableDTO updateTable(Long id, TableDTO tableDTO) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Стіл не знайдено"));

        table.setSeats(tableDTO.getSeats());
        table.setLocation(tableDTO.getLocation());
        table.setAvailability(tableDTO.getAvailability());
        table.setType(tableDTO.getType());
        table.setMinimumOrder(tableDTO.getMinimumOrder());
        table.setImage(tableDTO.getImage());

        Table updatedTable = tableRepository.save(table);
        return tableMapper.toDTO(updatedTable);
    }

    // Видалити стіл
    public void deleteTable(Long id) {
        if (!tableRepository.existsById(id)) {
            throw new RuntimeException("Стіл не знайдено");
        }
        tableRepository.deleteById(id);
    }
}
