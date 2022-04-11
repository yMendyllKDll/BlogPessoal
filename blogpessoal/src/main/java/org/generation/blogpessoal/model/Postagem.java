package org.generation.blogpessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity													 //Transforma em tabela
@Table(name="tb_postagens")                              //Nome da tabela
public class Postagem {
	
	@Id                                                //id como chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Auto increment
	private Long id;
	
	@NotNull											//Dado nulo
	private String titulo;
	
	@NotNull
	@Size(min=4, max=50)								//Tamanho da String
	private String texto;
	
	@UpdateTimestamp                                    //Formata de acordo com a data do seu pc
	private LocalDateTime data;
	
	@ManyToOne                                         //Chave estrangeira
	@JsonIgnoreProperties("postagem")                 //Evita o GET infinito
	private Tema tema;
	
	@ManyToOne                                         //Chave estrangeira
	@JsonIgnoreProperties("postagem")                 //Evita o GET infinito
	private Usuario usuario;

	//MANDAR E RECEBER DADOS GET/SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
