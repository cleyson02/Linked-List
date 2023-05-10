public class ListaLigada implements EstruturaDeDados {
    public No encontraNo(int chave) {

        if (inicio.getValor() == chave) {

            return inicio;
        }

        else {

            No no = inicio;

            while (no.getValor() != chave && no.getProximo() != null) {

                no = no.getProximo();

                if (no.getValor() == chave) {

                    return no;
                }
            }
            return null;
        }
    }

    public No inicio;

    @Override
    public boolean insert(int chave) {

        if (inicio == null) {

            inicio = new No(chave);

            return true;
        }

        else if (inicio.getProximo() == null) {

            this.inicio.setProximo(new No(chave));

            return true;
        }

        else {

            No verificador = inicio;

            while (verificador.getProximo() != null) {

                verificador = verificador.getProximo();

                if (verificador.getProximo() == null) {

                    verificador.setProximo(new No(chave));

                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean delete(int chave) {

        if (inicio.getValor() == chave) {

            inicio = inicio.getProximo();

            return true;
        }

        else {

            No no = inicio;

            while (no.getValor() != chave && no.getProximo() != null) {

                if (no.getProximo().getValor() == chave) {

                    no.setProximo(no.getProximo().getProximo());

                    return true;
                }
                no = no.getProximo();
            }
            return false;
        }
    }

    @Override
    public boolean search(int chave) {

        No no = inicio;

        if (no.getValor() == chave) {

            return true;
        }

        else {

            while (no.getProximo() != null) {

                no = no.getProximo();

                if (no.getValor() == chave) {

                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public int minimum() {

        int menor = inicio.getValor();

        No no = inicio;

        while (no.getProximo() != null) {

            no = no.getProximo();

            if (no.getValor() < menor) {

                menor = no.getValor();
            }
        }
        return menor;
    }

    @Override
    public int maximum() {

        int maior = inicio.getValor();

        No no = inicio;

        while (no.getProximo() != null) {

            no = no.getProximo();

            if (no.getValor() > maior) {

                maior = no.getValor();
            }
        }
        return maior;
    }

    @Override
    public int sucessor(int chave) {

        No no = encontraNo(chave);

        if (no.getValor() == chave && no.getProximo() != null) {

            return no.getProximo().getValor();
        }
        return -1;
    }

    @Override
    public int prodessor(int chave) {

        if (inicio.getValor() == chave) {

            return -1;
        }

        No no = inicio;

        No Proximo = encontraNo(chave);

        while (no.getProximo() != null) {

            if (no.getProximo() == Proximo) {

                return no.getValor();
            }
        }
        return -1;
    }
}