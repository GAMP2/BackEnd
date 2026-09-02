package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco")
    String nome;
    //@notblank: Garante que o campo seja vazio
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O email deve ser válido")
    private String Email;

    @Min(value = 0, message = "A idade não pode ser negativa")
    private int idade;

    //@NotNull: Garante que o campo não seja enviado como nulo.
    @NotNull(message = "A data de nascimento é obrigatótia")
    @Past(message = "A data de nascimento não pode ser uma data futura ")
    //@JsonFormat(pattern = "yyyy-MM-dd"): Garante que o Jackson consiga converter a String do JSON para a data em Java corretamente.
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dt_nasc;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    //@Pattern(regexp = "..."): Aplica uma Expressão Regular (Regex) para garantir a força da senha:
//(?=.*[0-9]): Exige pelo menos um número.
//
//(?=.*[a-z]): Exige pelo menos uma letra minúscula.
//
//(?=.*[A-Z]): Exige pelo menos uma letra maiúscula.
//
//(?=.*[@#$%^&+=!]): Exige pelo menos um símbolo/caractere especial.
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
            message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial"
    )
    private String senha;
}
