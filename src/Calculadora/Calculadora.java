
package Calculadora;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Calculadora {

    private JFrame frame;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora window = new Calculadora();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Calculadora() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 128, 192));

        frame.setTitle(" Ana Beatriz Soares Lima - 0023872");

        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("CALCULADORA");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBounds(145, 15, 180, 30);
        frame.getContentPane().add(lblTitulo);

        JLabel lblNumero1 = new JLabel("Primeiro número:");
        lblNumero1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNumero1.setBounds(40, 65, 120, 25);
        frame.getContentPane().add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(160, 65, 220, 25);
        frame.getContentPane().add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Segundo número:");
        lblNumero2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNumero2.setBounds(40, 105, 120, 25);
        frame.getContentPane().add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(160, 105, 220, 25);
        frame.getContentPane().add(txtNumero2);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResultado.setBounds(40, 145, 120, 25);
        frame.getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(160, 145, 220, 25);
        txtResultado.setEditable(false);
        frame.getContentPane().add(txtResultado);

        // BOTÃO ADIÇÃO
        JButton btnAdicao = new JButton("+");
        btnAdicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnAdicao.setBounds(40, 200, 65, 35);
        frame.getContentPane().add(btnAdicao);

        btnAdicao.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNumero1.getText());
                double n2 = Double.parseDouble(txtNumero2.getText());
                txtResultado.setText(String.valueOf(adicao(n1, n2)));
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            }
        });

        // BOTÃO SUBTRAÇÃO
        JButton btnSubtracao = new JButton("-");
        btnSubtracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSubtracao.setBounds(115, 200, 65, 35);
        frame.getContentPane().add(btnSubtracao);

        btnSubtracao.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNumero1.getText());
                double n2 = Double.parseDouble(txtNumero2.getText());
                txtResultado.setText(String.valueOf(subtracao(n1, n2)));
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            }
        });

        // BOTÃO MULTIPLICAÇÃO
        JButton btnMultiplicacao = new JButton("*");
        btnMultiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnMultiplicacao.setBounds(190, 200, 65, 35);
        frame.getContentPane().add(btnMultiplicacao);

        btnMultiplicacao.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNumero1.getText());
                double n2 = Double.parseDouble(txtNumero2.getText());
                txtResultado.setText(String.valueOf(multiplicacao(n1, n2)));
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            }
        });

        // BOTÃO DIVISÃO
        JButton btnDivisao = new JButton("/");
        btnDivisao.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnDivisao.setBounds(265, 200, 65, 35);
        frame.getContentPane().add(btnDivisao);

        btnDivisao.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNumero1.getText());
                double n2 = Double.parseDouble(txtNumero2.getText());
                txtResultado.setText(String.valueOf(divisao(n1, n2)));
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            } catch (ArithmeticException erro) {
                JOptionPane.showMessageDialog(frame, erro.getMessage());
            }
        });

        // BOTÃO POTÊNCIA
        JButton btnPotencia = new JButton("^");
        btnPotencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnPotencia.setBounds(340, 200, 65, 35);
        frame.getContentPane().add(btnPotencia);

        btnPotencia.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNumero1.getText());
                double n2 = Double.parseDouble(txtNumero2.getText());
                txtResultado.setText(String.valueOf(potencia(n1, n2)));
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            }
        });

    }

    // MÉTODO 1 - ADIÇÃO
    public double adicao(double n1, double n2) {
        return n1 + n2;
    }

    // MÉTODO 2 - SUBTRAÇÃO
    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    // MÉTODO 3 - MULTIPLICAÇÃO
    public double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }

    // MÉTODO 4 - DIVISÃO
    public double divisao(double n1, double n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return n1 / n2;
    }

    // MÉTODO 5 - POTÊNCIA
    public double potencia(double n1, double n2) {
        return Math.pow(n1, n2);
    }

}
