package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteOrdenacao {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1); //passa para a conta quem é o titular dela
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);
        
        System.out.println("Imprimindo a lista na ordem de inserção");
        for (Conta conta : lista) {
			System.out.println(conta);
		}
        System.out.println("-------");
        
        System.out.println("Imprimindo a lista na ordem do nome do Titular");
		lista.sort(new ComparadorTitular()); // simplifica o código - compara pelo nome do titular
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		System.out.println("-------");
//      ComparadorConta comparador = new ComparadorConta();
//      ComparadorTitular titularComparator = new ComparadorTitular();
//      lista.sort(titularComparator);
		System.out.println("Imprimindo na ordem	 do número da Conta");
		Collections.sort(lista, new ComparadorConta()); // compara pela conta usando collections
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		System.out.println("-------");
		System.out.println("Imprimindo pela Ordem Natural (saldo) definida na classe Conta");
		Collections.sort(lista); // ordena pela ordem natural
		for (Conta conta : lista) {
			System.out.println(conta);
			
		}
		


		

	}
}

class ComparadorTitular implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {
		String nomeC1 = c1.getTitular().getNome();
		String nomeC2 = c2.getTitular().getNome();
		
		return nomeC1.compareTo(nomeC2);
	}
	
}

//classe que compara pelo número da conta
class ComparadorConta implements Comparator<Conta> {
	@Override
	public int compare(Conta c1, Conta c2) {
		return Integer.compare(c1.getNumero(), c2.getNumero());
//		return c1.getNumero() - c2.getNumero();
	}
//		if(c1.getNumero() < c2.getNumero()) {
//			return -1;
//		} 
//		if(c1.getNumero() > c2.getNumero()) {
//			return 1;
//		}
//		return 0;
//	}
}
