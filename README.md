# Simulador de venda de ingressos de um cinema
## Pacotes necessários
[**Gson**](https://search.maven.org/artifact/com.google.code.gson/gson/2.10/jar)
## Alterações realizadas
- Classes Cliente e Entidade :
  - Não foram feitas alterações.
- Classe Filme:
  - Adicionado um novo atributo inteiro **ContagemdeIngressos**, que irá contabilizar o número de ingressos disponíveis para serem comprados de cada filme;
  - Adicionados getter e setter para tal atributo;
  - Alterado método *toString* (exibição do ContadordeIngresso);
- Classe Ingresso:
  - Alterado tipo do atributo **valor** de *float* para *double*.
  - Alterado tipo do atributo **horarioEntrado** de *String* para *inteiro*.
    > A manipulação do horário da forma anterior envolveria o uso de bibliotecas de manipulção de data e hora, o que tornaria o trabalho mais "trabalhoso" sem motivo.
  - Adicionada dois construtores: um que recebe um ingresso como parâmetro e outro que recebe um id, filme e horarioEntrada (serão usados no programa principal).
- Classe Venda (classe totalmente reformulada):
  - Adicionado o atributo do tipo lista encadeada **IngressosComprados**, que salvará os ingressos que cada cliente irá comprar.
  - Adicionado o atributo do tipo Cliente **ClientedaVenda**, que salvará as informações do cliente.
  - Adicionado um construtor que recebe um ingresso do tipo Ingresso e um cliente do tipo Cliente.
  - Adicionados getters e alterado o método *toString*.
  
