package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="order_number")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    /**
     * имя заказа
     */
    @Column(name = "name_order")
    private String nameOrder;

    /**
     * номер заказа
     */
    @Column(name = "number_order")
    private String numberOrder;

    /**
     * дата начала работ по заказу
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;

    /**
     * дата окончания работ по заказу
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "finish_date")
    private Date finishDate;

    /**
     * цвет изделия
     */
    @Column(name = "color")
    private String color;

    /**
     * квадратура
     */
    @Column(name = "quadrature")
    private Float quadrature;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TechnologicalProcess> technologicalProcesses = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "order_cutter",
            joinColumns = @JoinColumn(name = "id_order", foreignKey = @ForeignKey(name = "order_cutter_fk")),
            inverseJoinColumns = @JoinColumn(name = "id_cutter", foreignKey = @ForeignKey(name = "cutter_order_fk")))
    private Set<Cutter> cutters = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "order_baguette",
            joinColumns = @JoinColumn(name = "id_order", foreignKey = @ForeignKey(name = "order_baguette_fk")),
            inverseJoinColumns = @JoinColumn(name = "id_baguette", foreignKey = @ForeignKey(name = "baguette_order_fk")))
    private Set<Baguette> baguettes = new HashSet<>();
}
