
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
## video de apresentacao 
## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

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
├── README.md
├── resources/
│   ├── images/
│   │   ├── pawn_white.png
│   │   ├── pawn_black.png
│   │   └── ...
└── ...
```
## Como Executar

1. Clone o repositório:
```git
git clone https://github.com/seu-usuario/chess.git
``` 
2. Entre na pasta chess e entre no cmd
3. digite o seguinte comando 
```cmd
java -jar chess.jar
```
## Autores

- [@octokatherine](https://www.github.com/octokatherine)

