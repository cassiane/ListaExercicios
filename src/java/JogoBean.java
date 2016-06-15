
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gx2
 */
@ManagedBean
@SessionScoped
public class JogoBean {

    private String nome;
    private int numeroSorteado;
    private int numeroTentativas;
    private int numeroPalpite;
    Random ran = new Random();

    public JogoBean() {
        numeroSorteado = ran.nextInt(1000);
    }

    public String jogar() {
        this.numeroTentativas++;
        if (this.numeroPalpite == this.numeroSorteado) {
            return "Acerto";
        } else {
            if(this.numeroPalpite > this.numeroSorteado){
                enviarMensagem("O número sorteado é menor que este!");
            }else if(this.numeroPalpite < this.numeroSorteado){
                enviarMensagem("O número sorteado é maior que este!");
            }            
        }
        return null;
    }
    
    public String desistir(){
        return "desistir";
    }
    public void enviarMensagem(String mensagem){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensagem+"."));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public void setNumeroTentativas(int numeroTentativas) {
        this.numeroTentativas = numeroTentativas;
    }

    public int getNumeroPalpite() {
        return numeroPalpite;
    }

    public void setNumeroPalpite(int numeroPalpite) {
        this.numeroPalpite = numeroPalpite;
    }
}
