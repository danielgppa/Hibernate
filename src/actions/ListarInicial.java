package actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Aluno;

public class ListarInicial {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a inicial do nome do aluno: ");
        String inicial = sc.nextLine();
        TypedQuery<Aluno> query = manager.createQuery("select a from Aluno a where a.nome like '" + inicial + "%'",
                Aluno.class);
        List<Aluno> alunos = query.getResultList();
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento().getTime());
            System.out.println("Naturalidade: " + aluno.getNaturalidade());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println();
        }
        manager.close();
        factory.close();
        sc.close();
    }
}