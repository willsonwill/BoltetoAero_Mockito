/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.service;

import com.com470.boleto.app.controller.BoletoController;
import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author WILL
 */
public class BoletoServiceTest {
    
    // 1 mokear o simular de la que depende la clase
    @Mock
    private BoletoDao boletoDao;
    
    // 2 Injeccion del mock de nuestra clase
    @InjectMocks
    BoletoController boletoController;
    
    @InjectMocks
    BoletoService boletoService;
    
    public BoletoServiceTest() {
    }
    
    @Before
    public void setUp() {
         MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testCreateBoleto() {
        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoService.createBoleto(boleto)).thenReturn(boleto);
        assertThat(boletoService.createBoleto(boleto),Matchers.equalTo(boleto));
    }
    
    @Test
    public void testGetBoletoById() {
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("juan Parca");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.1@gmail.com");
        
        Mockito.when(boletoService.getBoletoById(1)).thenReturn(boleto);
        assertThat(boletoService.getBoletoById(1),Matchers.equalTo(boleto));
    }

    @Test
    public void testGetAllBoletos() {
        List<Boleto> boletos = new ArrayList<Boleto>();
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("juan Parca");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.1@gmail.com");
        
        boletos.add(boleto);
        Mockito.when(boletoService.getAllBoletos()).thenReturn(boletos);
        assertThat(boletoService.getAllBoletos(), Matchers.equalTo(boletos));
    }
    
    
    
    @Test
    public void testUpdateBoleto() {
        Boleto boleto =new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("juan Parca");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.1@gmail.com");
        String email="jorgedelascasas@gmail.com";
        Mockito.when(boletoService.getBoletoById(1)).thenReturn(boleto);
        boleto.setEmail(email);
        Mockito.when(boletoService.createBoleto(boleto)).thenReturn(boleto);
        assertThat(boletoService.updateBoleto(1, "jorge.1@gmail.com"),Matchers.equalTo(boleto));
    }
    
    @Test
    public void testDeleteBoleto() {
       // Mockito.doNothing().when(boletoService).deleteBoleto(1);
    }
}
