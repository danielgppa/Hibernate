package actions;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import model.Aluno;

public class InserirAluno {
    public static void main(String[] args) throws ParseException {
        Aluno aluno1 = new Aluno();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        aluno1.setNome(sc.nextLine());
        System.out.println("Digite o email do aluno: ");
        aluno1.setEmail(sc.nextLine());
        System.out.println("Digite o cpf do aluno: ");
        aluno1.setCpf(sc.nextLine());
        System.out.println("Digite a data de nascimento do aluno: ");
        String dataNascimento = sc.nextLine();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date data = df.parse(dataNascimento);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        aluno1.setDataNascimento(calendar);

        System.out.println("Digite a naturalidade do aluno: ");
        aluno1.setNaturalidade(sc.nextLine());
        System.out.println("Digite o endereço do aluno: ");
        aluno1.setEndereco(sc.nextLine());
        sc.close();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(aluno1);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

        System.out.println("ID do aluno: " + aluno1.getId());
    }
}
