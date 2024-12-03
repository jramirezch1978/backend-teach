package com.mindefdb.services.transactionals.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "t_order_detail") 
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_order_item", columnDefinition = "NUMERIC(8,0)")
	private Long idOrderItem;
	
	@Column(name = "articulo")
    private String articulo;  // Cambiado a minúscula
    
    @Column(name = "cantidad")
    private Double cantidad;  // Cambiado a minúscula
	
	@ManyToOne
	@JoinColumn(name="id_order", columnDefinition = "NUMERIC(8,0)")
	private Order order;
}
