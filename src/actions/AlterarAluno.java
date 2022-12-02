package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class AlterarAluno {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        System.out.println("Digite o ID do aluno: ");
        Aluno aluno = manager.find(Aluno.class, sc.nextLong());
        System.out.println("Digite o nome do aluno: ");
        sc.nextLine();
        aluno.setNome(sc.nextLine());
        System.out.println("Digite o email do aluno: ");
        aluno.setEmail(sc.nextLine());
        System.out.println("Digite o cpf do aluno: ");
        aluno.setCpf(sc.nextLine());
        System.out.println("Digite a data de nascimento do aluno: ");
        String dataNascimento = sc.nextLine();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date data = df.parse(dataNascimento);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        aluno.setDataNascimento(calendar);

        System.out.println("Digite a naturalidade do aluno: ");
        aluno.setNaturalidade(sc.nextLine());
        System.out.println("Digite o endereço do aluno: ");
        aluno.setEndereco(sc.nextLine());
        sc.close();
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
