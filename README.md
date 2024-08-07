
# Projeto de Xadrez em Java

### Descrição

Este projeto é uma implementação de um jogo de xadrez utilizando Java, com interface gráfica desenvolvida em Java Swing e renderização de peças e tabuleiro utilizando Graphics e Graphics2D.

## Funcionalidades

* Movimentação de todas as peças de acordo com as regras do xadrez.
* Verificação de cheque.
* Promoção de peão ao alcançar a última fileira do tabuleiro.
* Implementação do movimento de roque.
* Interface gráfica interativa.
* Mensagens de alerta para situações de cheque.
## video de apresentação do projeto 

https://github.com/user-attachments/assets/6f260d5c-4213-41c5-876d-a13495713bf9

### Vídeo mais completo mostrando o projeto está [aqui!!](https://www.youtube.com/watch?v=hnYlqXNdd2M)



## Screenshots

![Captura de tela de 2024-08-07 08-31-40](https://github.com/user-attachments/assets/ba5e18c3-ca3b-44d2-ab36-c73439d7da8a)
![Captura de tela de 2024-08-07 08-29-09](https://github.com/user-attachments/assets/7e1fa386-5c70-48a6-b2e0-e2fb1bd240b6)
![image](https://github.com/user-attachments/assets/b2f49b83-781f-4e1f-9c00-2138b1a73436)



## Tecnologias Utilizadas

- Java SE 8+
- Java Swing para a interface gráfica.
- Graphics e Graphics2D para renderização.
- Logger para registro de eventos.
- JOptionPane para diálogos.
## Estrutura do Projeto

```MD
chess/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ulisses/
│   │               └── chess/
│   │                   ├── bord/
│   │                   │   └── Board.java
│   │                   ├── pieces/
│   │                   │   ├── Piece.java
│   │                   │   ├── Pawn.java
│   │                   │   ├── Rook.java
│   │                   │   ├── Knight.java
│   │                   │   ├── Bishop.java
│   │                   │   ├── Queen.java
│   │                   │   └── King.java
│   │                   ├── gui/
│   │                   │   ├── ChessPanel.java
│   │                   │   └── ChessGUI.java
│   │                   ├── utils/
│   │                   │   └── Color.java
│   │                   └── chess.java
├── resources/
│   ├── images/
│   │   ├── pawn_white.png
│   │   ├── pawn_black.png
│   │   └── ...
├── README.md
├── Java.gitignore
├── Chess.jar
```
## Como Executar

1. Clone o repositório:
```git
git clone https://github.com/ulisses953/java-Chess.git
``` 
2. Entre na pasta chess e entre no cmd
3. digite o seguinte comando 
```cmd
java -jar chess.jar
```
## Autores

- [@ulisses953](https://github.com/ulisses953)

