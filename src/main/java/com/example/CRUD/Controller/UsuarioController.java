package com.example.CRUD.Controller;


import com.example.CRUD.Repository.UsuarioRepository;
import com.example.CRUD.Model.Usuario;
import com.example.CRUD.Services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AutenticacaoService autenticacaoService;

    @GetMapping("/cadastrar")
    public String formularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrar";
    }

    @PostMapping ("/cadastrar")
    public String salvarUsuario (@ModelAttribute Usuario usuario){
        usuarioRepository.save(usuario);
        return "index" ;
    }

    @GetMapping("/login")
    public String mostrarFormularioDeLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String cpf, @RequestParam String senha, Model model) {
        if (autenticacaoService.autenticar(cpf, senha)) {
            return "redirect:/template";
        } else {
            model.addAttribute("erro", "CPF ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/listar")
    public String listaProdutos(@ModelAttribute Usuario usuario, Model model){
        List<Usuario> listaUsuario = (List<Usuario>) usuarioRepository.findAll();
        model.addAttribute("usuarios",listaUsuario);
        return "listar";
    }

    @GetMapping ("/alterar/{id}" )
    public String altPessoa(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioRepository .findById(Math.toIntExact(id)).get();
        model.addAttribute( "usuario", usuario);
        return "alterar" ;
    }

    @PostMapping ("/alterar")
    public String alterarProduto (@ModelAttribute Usuario novoUsuario, Model model) {
        usuarioRepository .save(novoUsuario);
        List<Usuario> listaUsuario = (List<Usuario>) usuarioRepository .findAll();
        model.addAttribute( "usuarios", listaUsuario );
        return "listar" ;
    }

}

