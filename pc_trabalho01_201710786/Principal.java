/* ***************************************************************
* Autor............: Charlesson Mendes Pereira
* Matricula........: 201710786
* Inicio...........: 30/01/2022
* Ultima alteracao.: 05/02/2022
* Nome.............: Principal
* Funcao...........: Montagem e configuracao da interface
*************************************************************** */

//Importacao de classes
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//Fim da importacao de classes

public class Principal extends Application{//Inicio da classe principal
  //Inicio dos atributos da classe
  private Televisao televisao;

  private Stage stage;
  private Stage stageControle;

  private Scene scene;
  private Scene sceneControle;

  private Text txtRotuloVisorCanalAtual;
  private Text txtCanalAtual;
  private Text txtRotuloVisorVolume;
  private Text txtVolume;

  private Rectangle visorCanalAtual;
  private Rectangle visorVolume;
  private Rectangle telaDesligada;
  private Rectangle bordaPlayer;

  private Group root;
  private Group rootControle;

  private Button btnLigar;
  private Button btnDesligar;
  private Button btnPegarControle;
  private Button btnGuardarControle;
  private Button btnVoltarCanal;
  private Button btnAvancarCanal;
  private Button btnAumentarVolume;
  private Button btnDiminuirVolume;
  //Fim dos atributos da classe

  /* ***************************************************************
  * Metodo: inicializar
  * Funcao: inicializar os atributos da classe
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  private void inicializar() {
    root = new Group(); //Instanciando o atributo root
    rootControle = new Group(); //Instanciando o atributo rootControle

    televisao = new Televisao(); //Instanciando o atributo televisao

    //Adicionando os objetos da Classe MediaView ao ArrayList canais do objeto televisao
    televisao.getCanais().add(new MediaView(new MediaPlayer(new Media(new File(".\\videos/natureza.mp4").toURI().toString()))));
    televisao.getCanais().add(new MediaView(new MediaPlayer(new Media(new File(".\\videos/cidade1.mp4").toURI().toString()))));
    televisao.getCanais().add(new MediaView(new MediaPlayer(new Media(new File(".\\videos/cidade2.mp4").toURI().toString()))));
    televisao.getCanais().add(new MediaView(new MediaPlayer(new Media(new File(".\\videos/chuva.mp4").toURI().toString()))));
    televisao.getCanais().add(new MediaView(new MediaPlayer(new Media(new File(".\\videos/cachoeira.mp4").toURI().toString()))));
    //Fim da adicao dos canais

    //Setando os atributos filtro, posicao no eixo x e y e a largura dos objetos no ArrayList canais
    televisao.getCanais().get(0).setSmooth(true);
    televisao.getCanais().get(0).setLayoutX(20);
    televisao.getCanais().get(0).setLayoutY(30);
    televisao.getCanais().get(0).setFitWidth(400);

    televisao.getCanais().get(1).setSmooth(true);
    televisao.getCanais().get(1).setLayoutX(20);
    televisao.getCanais().get(1).setLayoutY(30);
    televisao.getCanais().get(1).setFitWidth(400);

    televisao.getCanais().get(2).setSmooth(true);
    televisao.getCanais().get(2).setLayoutX(20);
    televisao.getCanais().get(2).setLayoutY(30);
    televisao.getCanais().get(2).setFitWidth(400);

    televisao.getCanais().get(3).setSmooth(true);
    televisao.getCanais().get(3).setLayoutX(20);
    televisao.getCanais().get(3).setLayoutY(30);
    televisao.getCanais().get(3).setFitWidth(400);

    televisao.getCanais().get(4).setSmooth(true);
    televisao.getCanais().get(4).setLayoutX(20);
    televisao.getCanais().get(4).setLayoutY(30);
    televisao.getCanais().get(4).setFitWidth(400);
    //Fim da configuracao dos atributos dos elementos do ArrayList canais

    txtRotuloVisorCanalAtual = new Text("Canal:"); //Instanciando atributo da classe Text
    txtRotuloVisorCanalAtual.setFont(Font.font("Arial", 15)); //Setando a fonte do atributo
    txtRotuloVisorCanalAtual.setX(450); //Setando o posicionamento no eixo x
    txtRotuloVisorCanalAtual.setY(155); //Setando o posicionamento no eixo y

    txtCanalAtual = new Text(); //Instanciando atributo da classe Text
    txtCanalAtual.setFill(Color.RED); //Setando a cor do objeto
    txtCanalAtual.setFont(Font.font("Arial", 39)); //Setando a fonte do atributo
    txtCanalAtual.setX(460); //Setando o posicionamento no eixo x
    txtCanalAtual.setY(200); //Setando o posicionamento no eixo y

    txtRotuloVisorVolume = new Text("Volume:"); //Instanciando atributo da classe Text
    txtRotuloVisorVolume.setFont(Font.font("Arial", 15)); //Setando a fonte do atributo
    txtRotuloVisorVolume.setX(446); //Setando o posicionamento no eixo x
    txtRotuloVisorVolume.setY(250); //Setando o posicionamento no eixo y

    txtVolume = new Text(); //Instanciando atributo do tipo Text
    txtVolume.setX(450); //Setando o posicionamento no eixo x
    txtVolume.setY(278); //Setando o posicionamento no eixo y

    visorCanalAtual = new Rectangle(448, 160, 50, 50); //Instanciando objeto da classe Rectangle
    visorCanalAtual.setFill(null); //Setando a cor do atributo
    visorCanalAtual.setStroke(Color.BLACK); //Setando a cor do contorno do atributo

    visorVolume = new Rectangle(444, 260, 100, 30); //Instanciando objeto da classe Rectangle
    visorVolume.setFill(null); //Setando a cor do atributo
    visorVolume.setStroke(Color.BLACK); //Setando a cor do contorno do atributo

    telaDesligada = new Rectangle(20, 30, 400, 220); //Instanciando objeto da classe Rectangle
    telaDesligada.setFill(Color.BLACK); //Setando a cor do contorno do atributo

    bordaPlayer = new Rectangle(20, 30, 400, 220); //Instanciando objeto da classe Rectangle
    bordaPlayer.setFill(null); //Setando a cor do contorno do atributo
    bordaPlayer.setStrokeWidth(10); //Setando a expessura do contorno
    bordaPlayer.setStroke(Color.BLACK); //Setando a cor do contorno do atributo
    bordaPlayer.setArcHeight(10); //Setando a propriedade ArcHeight do contorno para suavizar os cantos
    bordaPlayer.setArcWidth(10); //Setando a propriedade ArcHeight do contorno para suavizar os cantos

    btnAvancarCanal = new Button(">"); //Instanciando objeto da classe Button
    btnAvancarCanal.setLayoutX(108); //Setando o posicionamento no eixo x
    btnAvancarCanal.setLayoutY(50); //Setando o posicionamento no eixo y
    btnAvancarCanal.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnAvancarCanal quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().stop(); //Parando a reproducao do player atual
        televisao.avancarCanal(); //Chamada ao metodo avancarCanal 
        root.getChildren().remove(0); //Remove o player que esta na posicao 0 do root
        root.getChildren().add(0, televisao.getCanais().get(televisao.getCanalAtual())); //Adiciona o novo player a posicao zero do root, apos alterado pelo metodo avancarCanal
        txtCanalAtual.setText((televisao.getCanalAtual() + 1) + ""); //Seta o conteudo do atributo txtCanalAtual
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setVolume((double)(televisao.getVolume()*10)/100); //Atribui o volume atual ao novo player
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().play();//Comeca a reproduzir
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setCycleCount(Integer.MAX_VALUE);//Faz reproduzir por tempo indeterminado
      }//Fim do metodo handle
    });//Fim da chamada ao metodo setOnAction

    btnVoltarCanal = new Button("<"); //Instanciando objeto da classe Button
    btnVoltarCanal.setLayoutX(20); //Setando o posicionamento no eixo x
    btnVoltarCanal.setLayoutY(50); //Setando o posicionamento no eixo y
    btnVoltarCanal.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnVoltarCanal quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().stop(); //Parando a reproducao do player atual
        televisao.voltarCanal(); //Chamada ao metodo voltarCanal       
        root.getChildren().remove(0); //Remove o player que esta na posicao 0 do root
        root.getChildren().add(0, televisao.getCanais().get(televisao.getCanalAtual())); //Adiciona o novo player a posicao zero do root, apos alterado pelo metodo voltarCanal
        txtCanalAtual.setText((televisao.getCanalAtual() + 1) + ""); //Seta o conteudo do atributo txtCanalAtual
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setVolume((double)(televisao.getVolume()*10)/100); //Atribui o volume atual ao novo player
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().play(); //Comeca a reproduzir
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setCycleCount(Integer.MAX_VALUE); //Faz reproduzir por tempo indeterminado
      }//Fim do metodo handle
    });//Fim da chamada ao metodo setOnAction

    btnAumentarVolume = new Button("+"); //Instanciando objeto da classe Button
    btnAumentarVolume.setLayoutX(62); //Setando o posicionamento no eixo x
    btnAumentarVolume.setLayoutY(10); //Setando o posicionamento no eixo y
    btnAumentarVolume.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnAumentarVolume quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        if(televisao.getVolume() < 10) { //Verifica se o volume atual do player e menor que 10
          televisao.aumentarVolume(); //Chama o metodo diminuirVolume
          txtVolume.setText(repetir(" | ", televisao.getVolume())); //Seta o conteudo de txtVolume com o resultado do metodo repetir
          televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setVolume((double)(televisao.getVolume()*10)/100);//Aplica o volume alterado ao player
        }//Fim do if
      }//Fim do metodo handle
    });//Fim da chamada ao metodo setOnAction

    btnDiminuirVolume = new Button("-"); //Instanciando objeto da classe Button
    btnDiminuirVolume.setLayoutX(65); //Setando o posicionamento no eixo x
    btnDiminuirVolume.setLayoutY(90); //Setando o posicionamento no eixo y
    btnDiminuirVolume.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnDiminuirVolume quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        if(televisao.getVolume() > 0) { //Verifica se o volume atual do player e maior que 0
          televisao.diminuirVolume(); //Chama o metodo diminuirVolume
          txtVolume.setText(repetir(" | ", televisao.getVolume())); //Seta o conteudo de txtVolume com o resultado do metodo repetir
          televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setVolume((double)(televisao.getVolume()*10)/100); //Aplica o volume alterado ao player
        }//Fim do if
      }//Fim do metodo handle 
    });//Fim da chamada ao metodo setOnAction

    btnGuardarControle = new Button("Guardar controle"); //Instanciando objeto da classe Button
    btnGuardarControle.setLayoutX(23); //Setando o posicionamento no eixo x
    btnGuardarControle.setLayoutY(150); //Setando o posicionamento no eixo y
    btnGuardarControle.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnGuardarControle quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0){
        stageControle.close(); //Fecha o stageControle
      }//Fim do metodo handle 
    });//Fim da chamada ao metodo setOnAction

    //Adicionando os elementos necessarios ao rootControle
    rootControle.getChildren().addAll(btnGuardarControle, btnAumentarVolume, btnDiminuirVolume, btnVoltarCanal, btnAvancarCanal);

    btnPegarControle = new Button("Pegar controle"); //Instanciando objeto da classe Button
    btnPegarControle.setLayoutX(450); //Setando o posicionamento no eixo x
    btnPegarControle.setLayoutY(90); //Setando o posicionamento no eixo y
    btnPegarControle.setDisable(true); //Desabilitando o botao
    btnPegarControle.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnPegarControle quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        stageControle.show(); //Abre o stageControle
      }//Fim do metodo handle   
    });//Fim da chamada ao metodo setOnAction

    btnDesligar = new Button("Desligar"); //Instanciando objeto da classe Button
    btnDesligar.setLayoutX(450); //Setando o posicionamento no eixo x
    btnDesligar.setLayoutY(60); //Setando o posicionamento no eixo y
    btnDesligar.setDisable(true); //Desabilitando o botao
    btnDesligar.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnDesligar quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        btnDesligar.setDisable(true); //Desabilita o botao btnDesligar
        btnPegarControle.setDisable(true); //Desabilita o botao btnPegarControle
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().stop(); //Parando a reproducao do player atual
        root.getChildren().remove(0); //Remove o objeto na posicao 0 no root
        root.getChildren().add(0, telaDesligada); //Adiciona na posicao 0 do root o objeto que representa a telaDesligada
        txtCanalAtual.setText(""); //Seta o conteudo de txtCanalAtual
        txtVolume.setText(""); //Seta o conteudo de txtVolume
      }//Fim do metodo handle    
    });//Fim da chamada ao metodo setOnAction

    btnLigar = new Button("Ligar"); //Instanciando objeto da classe Button
    btnLigar.setLayoutX(450); //Setando o posicionamento no eixo x
    btnLigar.setLayoutY(30); //Setando o posicionamento no eixo y
    btnLigar.setOnAction(new EventHandler<ActionEvent>() { //Setando o evento de acao do botao
      /* ***************************************************************
      * Metodo: handle
      * Funcao: define o comportamento de btnLigar quando pressionado
      * Parametros: arg0 do tipo ActionEvent
      * Retorno: Sem retorno
      *************************************************************** */
      @Override
      public void handle(ActionEvent arg0) {
        btnDesligar.setDisable(false); //Habilita o botao btnDesligar
        btnPegarControle.setDisable(false); //Habilita o botao btnPegarControle
        root.getChildren().remove(0); //Remove o objeto na posicao 0 no root
        root.getChildren().add(0, televisao.getCanais().get(0)); //Adiciona na posicao 0 do root o objeto na posicao 0 de canais
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().play(); //Reproduz o video
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setVolume((double)(televisao.getVolume()*10)/100); //Seta o volume
        televisao.getCanais().get(televisao.getCanalAtual()).getMediaPlayer().setCycleCount(Integer.MAX_VALUE); //Mantem o video repetindo indefinidamente
        txtCanalAtual.setText((televisao.getCanalAtual()+1) + ""); //Seta o conteudo de txtCanalAtual
        txtVolume.setText(repetir(" | ", televisao.getVolume())); //Seta o conteudo de txtVolume
      }//Fim do metodo handle      
    });//Fim da chamada ao metodo setOnAction

    //Adicionando os elementos necessarios ao root
    root.getChildren().addAll(telaDesligada, txtRotuloVisorCanalAtual, txtCanalAtual, txtRotuloVisorVolume,
    txtVolume, visorCanalAtual, visorVolume, btnDesligar, btnLigar, btnPegarControle, bordaPlayer);

    
    scene = new Scene(root, 550, 300, Color.DARKGRAY); //Instanciando e definindo algumas propriedades do atributo scene
    sceneControle = new Scene(rootControle, 150, 200, Color.BLACK); //Instanciando e definindo algumas propriedades do atributo sceneControle

    stageControle = new Stage(); //Instanciando atributo da classe Stage
    stageControle.setScene(sceneControle); //Setando a scene do Atributo stageControle
    stageControle.setResizable(false); //Setando a propriedade redimensionavel
    stageControle.setTitle("Controle"); //Setando o titulo

    stage = new Stage(); //Instanciando atributo da classe Stage
    stage.setScene(scene); //Setando a scene do Atributo stage
    stage.setResizable(false); //Setando a propriedade redimensionavel
    stage.setTitle("Televisao"); //Setando o titulo
    stage.show(); //Chamando o metodo show para mostrar o stage
  }//Fim do metodo inicializar

  /* ***************************************************************
  * Metodo: Principal
  * Funcao: define o comportamento inicial de uma instancia da classe
  * Parametros: Sem parametros
  * Retorno: Sem retorno
  *************************************************************** */
  public Principal() {
      inicializar();//Chamada ao metodo inicializar
  }//Fim do metodo Principal

  /* ***************************************************************
  * Metodo: start
  * Funcao: iniciar a API
  * Parametros: arg0 do tipo Stage
  * Retorno: Sem retorno
  *************************************************************** */
  @Override
  public void start(Stage arg0) throws Exception {}//Fim do metodo start

  /* ***************************************************************
  * Metodo: main
  * Funcao: executar o programa
  * Parametros: vetor args do tipo String
  * Retorno: Sem retorno
  *************************************************************** */
  public static void main(String[] args) throws Exception {
      launch(args);//Chamada ao metodo launch da classe Application
  }//Fim do metodo main

  /* ***************************************************************
  * Metodo: repetir
  * Funcao: repetir uma string por um determinado numero de vezes
  * Parametros: str do tipo String e vezes do tipo int
  * Retorno: retorna a string repetida pelo valor inserido
  *************************************************************** */
  public static String repetir(String str, int vezes) {
    String novaStr = ""; //Variavel do tipo string
    for(int i = 0; i < vezes; i++) { //Estrutura de repeticao
      novaStr += str; //Concatenando o parametro str em nova string pela quantidade passada como parametro
    }//Fim do laco for
    return novaStr.trim();
  }//Fim do metodo repetir
    
}//Fim da classe Principal