package Principal;
import java.util.Objects;
import javax.swing.JOptionPane;

import Conversao.ConverteMoedas;
import Conversao.ConverteTemperaturas;
import Escolha.EscolheConversor;
import Escolha.EscolheMoedas;
import Escolha.EscolheTemperaturas;
import Escolha.EscolheValor;
import Excecoes.TelaErro;

public class TelaPrincipal {
    public static void main(String[] args) {

        do {
            try {
                EscolheConversor escolheConversor = new EscolheConversor();
                EscolheValor escolheValor = new EscolheValor();

                double valorSelecionado = escolheValor.getValor();

                if (Objects.equals(escolheConversor.getOpcaoSelecionada(), "Conversor de moedas")) {
                    EscolheMoedas EscolheMoedas = new EscolheMoedas();
                    new ConverteMoedas(valorSelecionado, EscolheMoedas.getOpcaoSelecionada());
                } else if (Objects.equals(escolheConversor.getOpcaoSelecionada(), "Conversor de temperaturas")) {
                    EscolheTemperaturas EscolheTemperaturas = new EscolheTemperaturas();
                    new ConverteTemperaturas(valorSelecionado, EscolheTemperaturas.getOpcaoSelecionada());
                } 
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
                new TelaErro("O valor informado é inválido!");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                new TelaErro("Erro... Digite um valor válido!");
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?") != 1);

        JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");

        System.exit(0);
    }
}
