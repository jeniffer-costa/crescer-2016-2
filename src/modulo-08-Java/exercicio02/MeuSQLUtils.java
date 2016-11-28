/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicio02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeniffer.costa
 */
public class MeuSQLUtils {

    public static void main(String[] args) {
       executarInstrucao("C:\\Users\\diiego\\Documents\\NetBeansProjects\\Exercicio02\\pasta\\linha.sql");
    }

    public static void executarInstrucao(String arquivo) {
        String extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        if (extensao.equalsIgnoreCase(".sql")) {
            try (
                    FileReader file = new FileReader(arquivo);
                    BufferedReader lerArq = new BufferedReader(file);
                    ) {
                    String linha = lerArq.readLine();
                    final String query = linha;
                try (
                        final Connection connection = ConnectionUtils.getConnection();
                        final Statement statement = connection.createStatement();
                        ) {
                  statement.executeQuery(query);
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }
        } else {
            System.out.println("Arquivo incompatível!");
        }
    }
}
