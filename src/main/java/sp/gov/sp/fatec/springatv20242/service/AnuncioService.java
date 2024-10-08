// package sp.gov.sp.fatec.springatv20242.service;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;

// import sp.gov.sp.fatec.springatv20242.entity.Trabalho;
// import sp.gov.sp.fatec.springatv20242.repository.TrabalhoRepository;

// @Service
// public class TrabalhoService {

//     @Autowired
//     private TrabalhoRepository trabalhoRepo;

//     // Método para cadastro de um novo trabalho
//     public Trabalho novoTrabalho(Trabalho trabalho) {
//         // Valida se o título e o grupo estão preenchidos
//         if (trabalho == null || !StringUtils.hasText(trabalho.getTitulo()) || !StringUtils.hasText(trabalho.getGrupo())) {
//             throw new IllegalArgumentException("Título e grupo são obrigatórios!");
//         }

//         // Define a data/hora de entrega atual se não estiver preenchida
//         if (trabalho.getDataHoraEntrega() == null) {
//             trabalho.setDataHoraEntrega(LocalDateTime.now());
//         }

//         // Salva o trabalho no repositório
//         return trabalhoRepo.save(trabalho);
//     }

//     // Método para listar todos os registros da tabela Trabalho
//     public List<Trabalho> buscarTodos() {
//         return (List<Trabalho>) trabalhoRepo.findAll();
//     }

//     // Método para buscar trabalhos que contenham uma palavra no título e nota maior que um valor específico
//     public List<Trabalho> buscarPorPalavraNoTituloENotaMaiorQue(String palavra, Integer nota) {
//         if (palavra == null || nota == null) {
//             throw new IllegalArgumentException("Parâmetros inválidos!");
//         }
//         return trabalhoRepo.buscarPorPalavraNoTituloENotaMaiorQue(palavra, nota);
//     }
// }

package sp.gov.sp.fatec.springatv20242.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sp.gov.sp.fatec.springatv20242.entity.Anuncio;
import sp.gov.sp.fatec.springatv20242.repository.AnuncioRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepo;

    // Método para cadastrar um novo anúncio
    public Anuncio novoAnuncio(Anuncio anuncio) {
        // Verifica se o nome do produto não é nulo ou vazio
        if (anuncio == null || !StringUtils.hasText(anuncio.getNomeProduto())) {
            throw new IllegalArgumentException("Nome do produto é obrigatório!");
        }

        // Verifica se o preço é maior que zero
        if (anuncio.getPreco() == null || anuncio.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero!");
        }

        // Preenche a data/hora de cadastro com a data/hora atual se estiver em branco
        if (anuncio.getDataHoraCadastro() == null) {
            anuncio.setDataHoraCadastro(LocalDateTime.now());
        }

        // Salva o anúncio no repositório
        return anuncioRepo.save(anuncio);
    }

    // Método para listar todos os registros da tabela Anuncio
    public List<Anuncio> buscarTodos() {
        return (List<Anuncio>) anuncioRepo.findAll();
    }

    // Método para buscar anúncios cujo nome do produto contenha um texto ou o preço seja inferior a um valor
    public List<Anuncio> buscarPorNomeProdutoOuPrecoMenorQue(String texto, Float preco) {
        if (texto == null || preco == null) {
            throw new IllegalArgumentException("Parâmetros inválidos!");
        }
        return anuncioRepo.buscarPorNomeProdutoOuPrecoMenorQue(texto, preco);
    }
}
