package arrayList;

public class ArrayListSequencial<T> {

    //Atributos da classe
    private final int TAMANHO = 10;
    private T[] array = null;
    private int posicaoAtual = 0;

    public ArrayListSequencial() {
        array = (T[]) new Object[TAMANHO];
    }

    //Retorna um elemento de acordo com a posicao atual
    public T elementAt(int posicao)throws ArrayIndexOutOfBoundsException{

        if (posicao >= posicaoAtual || posicao < 0) {
            throw new ArrayIndexOutOfBoundsException("Erro!!");
        }

        return array[posicao];
    }

    //Retorna o tamanho do array
    public int getSize(){
        return posicaoAtual;
    }

    //Metodo que remove um elemento
    public T removeElement(int posicao) throws ArrayIndexOutOfBoundsException{

        if (posicao >= posicaoAtual || posicao < 0) {
            throw new ArrayIndexOutOfBoundsException("Erro");
        }

        T copy = array[posicao];

        for (int posInicial = posicao; posInicial < posicaoAtual - 1; posInicial++) {
            array[posInicial] = array[posInicial + 1];
        }

        //Atualiza a posicao de insercao
        posicaoAtual--;

        //Devolve a copia do objeto
        return copy;
    }

    //Metodo para a inserir um objeto em qualquer posicao do array
    public void insere(T novo, int posicao)throws ArrayIndexOutOfBoundsException{

        if (posicao < 0 || posicao > posicaoAtual) {
            throw new ArrayIndexOutOfBoundsException("Deu krepa");
        }

        //A posicao de insercao ja chegou ao final do array
        if (posicaoAtual == array.length)
        {
            realocaMemoria();
        }

        //A partir do local de insercao, desloca todos os elementos
        //para o lado
        for (int pos = posicaoAtual; pos > posicao; pos-- ) {
            array[pos] = array[pos - 1];
        }
        //Atualiza a posicao com o novo elemento
        array[posicao]  = novo;

        //incrementa o total de elementos do Array
        posicaoAtual++;
    }

    //Metodo para a inserir um objeto
    public void insere(T novo)
    {
        //A posicao de insercao ja chegou ao final do array
        if (posicaoAtual == array.length)
        {
            realocaMemoria();
        }

        //Insere o novo elemento no vetor
        array[posicaoAtual] = novo;

        //Atualiza a variavel que controla a posicao de insercao
        posicaoAtual++;
    }

    //Realoca memoria
    private void realocaMemoria() {

        System.out.println("Realocando....");
        T[] novo = (T[]) new Object[array.length + TAMANHO];

        for (int posicao = 0; posicao < array.length; posicao++)
        {
            novo[posicao] = array[posicao];
        }

        array = novo;
    }
}