package com.mindefdb.services.transactionals.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_order") 
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_order", columnDefinition = "NUMERIC(8,0)")
	private Long IdOrder;
	
	@Column(name = "nro_order")
	private String nroOrder;
	
	@Column(name = "cliente")
    private String cliente;  // Cambiado a minúscula
    
    @Column(name = "cod_moneda")
    private String codMoneda;
    
    @Column(name = "fec_compra")
    private Date fecCompra;
    
    @Column(name = "payment")
    private Float payment;
	
	//Relaciones o Llaves foraneas
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> items;
	
}
