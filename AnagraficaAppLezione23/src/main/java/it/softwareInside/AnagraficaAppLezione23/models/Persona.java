package it.softwareInside.AnagraficaAppLezione23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Persona {

	@Id
	@Size(min = 5, max = 5, message = "Il codice fiscale deve avere la lunghezza di 5")
	private String codiceFiscale;

	@Min(value = 15, message = "L'età deve essere di almeno 15")
	private int eta;

	@NotNull(message = "Nome o Cognome non possono essere null")
	@NotBlank(message = "Nome o Cognome non possono essere vuoti")
	private String nome, cognome;

}
