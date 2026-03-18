# Sistema de Threads em Java

## Descrição

Este projeto simula uma mesa de áudio onde várias faixas são executadas ao mesmo tempo utilizando **threads em Java**.

Cada música roda em uma thread independente, permitindo pausar e retomar individualmente, mantendo todas sincronizadas.

---

## Objetivo

Praticar conceitos de **Infraestrutura de Software**, principalmente:

* Threads
* Execução concorrente
* Sincronização entre processos

---

## Como funciona

* Cada faixa de áudio é representada por uma classe `Track`
* Cada `Track` roda em uma thread separada
* Um tempo global (`GlobalTime`) mantém todas as faixas sincronizadas
* O usuário controla tudo pelo terminal

---

## Como executar

1. Importar o projeto na IDE (Eclipse, IntelliJ ou VS Code)
2. Garantir que os arquivos `.wav` estão na pasta `src`
3. Executar a classe:

```
JavaThreads.java
```

---

## Controles

* `1 a 5` → pausar/retomar faixa
* `0` → encerrar programa

---

##  Estrutura

```
src
 ├── JavaThreads.java
 ├── Track.java
 ├── GlobalTime.java
 ├── arquivos .wav
```

---

## Contribuidores

- Emanoel Henrick Alves da Silva - [emanoelhenrick](https://github.com/emanoelhenrick)
- Jennifer Zeferino Cruz de Lima - [jenniferzeferino](https://github.com/jenniferzeferino)
- Lucas Vinicius - [Lucas-Viniicius](https://github.com/Lucas-Viniicius)
- Raiele Leite da Silva - [RaieleLeite](https://github.com/RaieleLeite)
- Rayssa Santana Ribeiro - [RayssaRR](https://github.com/RayssaRR)
