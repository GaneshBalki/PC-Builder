package com.demo.gaminggears.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Buildunit")
public class Buildunit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unitid")
    private int unitid;

    @ManyToOne
    @JoinColumn(name = "expid")
    private Expert expid;

    private int ram;
    private int ssd;
    private int cpu;
    private int processor;
    private int cpucooler;
    private int mouse;
    private int motherboard;
    private int gpu;

    // Constructors
    public Buildunit() {
    }

    public Buildunit(int unitid, Expert expid, int ram, int ssd, int cpu, int processor, int cpucooler, int mouse, int motherboard, int gpu) {
        this.unitid = unitid;
        this.expid = expid;
        this.ram = ram;
        this.ssd = ssd;
        this.cpu = cpu;
        this.processor = processor;
        this.cpucooler = cpucooler;
        this.mouse = mouse;
        this.motherboard = motherboard;
        this.gpu = gpu;
    }

    // Getters and Setters
    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public Expert getExpid() {
        return expid;
    }

    public void setExpid(Expert expid) {
        this.expid = expid;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getProcessor() {
        return processor;
    }

    public void setProcessor(int processor) {
        this.processor = processor;
    }

    public int getCpucooler() {
        return cpucooler;
    }

    public void setCpucooler(int cpucooler) {
        this.cpucooler = cpucooler;
    }

    public int getMouse() {
        return mouse;
    }

    public void setMouse(int mouse) {
        this.mouse = mouse;
    }

    public int getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(int motherboard) {
        this.motherboard = motherboard;
    }

    public int getGpu() {
        return gpu;
    }

    public void setGpu(int gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "BuildUnit{" +
                "unitid=" + unitid +
                ", expid=" + expid +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", cpu=" + cpu +
                ", processor=" + processor +
                ", cpucooler=" + cpucooler +
                ", mouse=" + mouse +
                ", motherboard=" + motherboard +
                ", gpu=" + gpu +
                '}';
    }
}