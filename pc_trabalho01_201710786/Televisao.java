/* ***************************************************************
* Autor............: Charlesson Mendes Pereira
* Matricula........: 201710786
* Inicio...........: 30/01/2022
* Ultima alteracao.: 05/02/2022
* Nome.............: Televisao
* Funcao...........: Simular algumas funcoes de uma televisao
*************************************************************** */

//Importacao de classes
import java.util.ArrayList;
import javafx.scene.media.MediaView;
//Fim da importacao de classes

public class Televisao {//Inicio da classe Televisao
  //Inicio dos atributos da classe
  private int volume;
  private int canalAtual;
  private ArrayList<MediaView> canais;
  //Fim dos atributos da classe

  /* ***************************************************************
  * Metodo: getVolume
  * Funcao: retornar o valor do atributo volume
  * Parametros: sem parametros
  * Retorno: retorna o conteudo do atributo volume
  *************************************************************** */
  public int getVolume() {
    return this.volume; //Retornando o valor do atributo volume
  }//Fim do metodo getVolume

  /* ***************************************************************
  * Metodo: setVolume
  * Funcao: setar o valor do atributo volume
  * Parametros: volume do tipo inteiro
  * Retorno: sem retorno
  *************************************************************** */
  public void setVolume (int volume) {
    if (volume >= 0 && volume <= 10) { //Verifica se o valor do parametro esta entra 0 e 10, incluindo-os
        this.volume = volume; //Atribui o valor do parametro ao atributo volume
    }//Fim do if
  }//Fim do metodo setVolume

  /* ***************************************************************
  * Metodo: getCanais
  * Funcao: retornar o valor do atributo canais
  * Parametros: sem parametros
  * Retorno: retorna um ArrayList<MediaView>
  *************************************************************** */
  public ArrayList<MediaView> getCanais() {
    return this.canais; //Retornando o valor do atributo canais
  }//Fim do metodo getCanais

  /* ***************************************************************
  * Metodo: setCanais
  * Funcao: setar o valor do atributo canais
  * Parametros: canais do tipo ArrayList<MediaView>
  * Retorno: sem retorno
  *************************************************************** */
  public void setCanais(ArrayList<MediaView> canais) {
    this.canais = canais;
  }//Fim do metodo setCanais

  /* ***************************************************************
  * Metodo: getCanalAtual
  * Funcao: retornar o valor do atributo canalAtual
  * Parametros: sem parametros
  * Retorno: canalAtual do tipo int
  *************************************************************** */
  public int getCanalAtual() {
    return this.canalAtual; //Retornando o valor do atributo canalAtual
  }//Fim do metodo getCanalAtual

  public void setCanalAtual(int canalAtual) {
    this.canalAtual = canalAtual;
  }
  //Fim dos metodos acessor e modificador do atributo canalAtual

  /* ***************************************************************
  * Metodo: corstrutor
  * Funcao: define o comportamento inicial de uma instancia da classe
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public Televisao() {
    this.canais = new ArrayList<MediaView>(); //Instancia o atributo canais
    this.setVolume(5); //Atribui o valor 5 ao atributo volume
    this.setCanalAtual(0); //Atribui o valor 0 ao atributo canalAtual
  }//Fim metodo construtor

  /* ***************************************************************
  * Metodo: aumentarVolume
  * Funcao: incrementar em 1 o valor do atributo volume
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public void aumentarVolume() {
    if(this.getVolume() < 10) //Verifica se o atributo volume e menor ou igual a 10
      this.setVolume(this.getVolume() + 1); //Incrementa o valor do atributo em 1 unidade
  }//Fim do metodo aumentarVolume

  /* ***************************************************************
  * Metodo: dimunuirVolume
  * Funcao: decrementar em 1 o valor do atributo volume
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public void diminuirVolume() {
    if(this.getVolume() > 0) //Verifica se o atributo volume e maior que 10
      this.setVolume(this.getVolume() - 1); //Decrementa o valor do atributo em 1 unidade
  }//Fim do metodo diminuirVolume

  /* ***************************************************************
  * Metodo: avancarCanal
  * Funcao: fazer o atributo canalAtual percorrer o atributo canais
            de forma prograssiva
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public void avancarCanal() {
    if(this.getCanalAtual() < this.getCanais().size() - 1) { //Verifica se o valor do canalAtual e menor que a ultima posicao de canais
      this.setCanalAtual(this.getCanalAtual() + 1); //Incrementa 1 ao valor de canalAtual
    } else this.setCanalAtual(0); //canalAtual recebe 0
  }//Fim do metodo avancarCanal

  /* ***************************************************************
  * Metodo: voltarCanal
  * Funcao: fazer o atributo canalAtual percorrer o atributo canais
            de forma regressiva
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public void voltarCanal() {
    if(this.getCanalAtual() >= 1) { //verifica se o canalAtual e maior ou igual a 1
      this.setCanalAtual(this.getCanalAtual() - 1); //Decrementa 1 ao valor de canalAtual
    } else this.setCanalAtual(this.getCanais().size() - 1); //Canal atual recebe o endereco do ultimo objeto de canais
  }//Fim do metodo avancar canal
}//Fim da classe televisao