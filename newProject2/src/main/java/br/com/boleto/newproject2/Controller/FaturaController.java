package br.com.boleto.newproject2.Controller;

import br.com.boleto.newproject2.Model.Fatura;
import br.com.boleto.newproject2.Service.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("faturas")
public class FaturaController {
    @Autowired
    private FaturaService faturaService;

    @GetMapping
    public ResponseEntity<List<Fatura>> getFaturas() {
        List<Fatura> ListarFaturas = faturaService.getFaturas();
        return ResponseEntity.status(302).body(ListarFaturas);
    }

    @PostMapping
    public ResponseEntity<Fatura> createFatura(@RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.CreateFatura(fatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Fatura>> getFatura(@PathVariable Long id) {
        Optional<Fatura> EncontrarFatura = faturaService.getFatura(id);
        return ResponseEntity.status(302).body(EncontrarFatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Fatura>> DeleteFatura(@PathVariable Long id) {
        Optional<Fatura> DeleteFatura = faturaService.deleteFatura(id);
        return ResponseEntity.status(HttpStatus.OK).body(DeleteFatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Fatura>> AtualizarFatura(@PathVariable Long id, @RequestBody Fatura fatura) {
        Optional<Fatura> UpdateFatura = Optional.ofNullable(faturaService.updateFatura(id, fatura));
        return ResponseEntity.status(202).body(UpdateFatura);
    }
}
