class Expressao {

    private String expressao;

    Expressao(String expressao) {
        this.expressao = expressao;
    }

    boolean verificar_delimitadores() {

        Pilha pilha = new Pilha(expressao.length());

        for (char c : expressao.toCharArray()) {

            switch (c) {
                case '(':
                case '[':
                case '{':
                    pilha.empilhar(c);
                    break;
                case ')':
                    if (pilha.topo() == '(') pilha.desempilhar();
                    else return false;
                    break;
                case ']':
                    if (pilha.topo() == '[') pilha.desempilhar();
                    else return false;
                    break;
                case '}':
                    if (pilha.topo() == '{') pilha.desempilhar();
                    else return false;
                    break;
            }
        }

        return pilha.vazia();
    }
}
