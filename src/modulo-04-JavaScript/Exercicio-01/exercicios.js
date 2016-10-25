//1. Pirâmide iluminatti
//Escreva uma função gerarPiramide(niveis) que imprime com console.log
//uma pirâmide com uma quantidade de níveis informada por parâmetro, utilizando os caracteres R$
function gerarPiramide(niveis){
 var x = '';
 for(var i=0, len = niveis; i < len; i++){
 x = 'R$' + x;
console.log(x);
}
}
gerarPiramide(9);

//2. Diglett dig, trio trio trio
//Escreva uma função diglettDig() que, utilizando console.log, imprime todos os números de 1 até 100, com duas exceções:
//quando o número for divisível por 3, imprima 'Diglett dig' invés do número, e
//quando o número for divisível por 5 (e não por 3), imprima 'trio trio trio' invés do número.
//Após ter essa lógica funcionando, altere a função para imprimir 'Diglett dig, trio trio trio'
//para números que são divisíveis tanto por 3 quanto por 5
//(e que continue imprimindo 'Diglett dig' ou 'trio trio trio' para os números divisíveis apenas por 3 ou 5).

function diglettDig(){
 for(var i=1;i<=100;i++){
   if((i % 5 === 0) && (i % 3 === 0)) {
     console.log('Diglett dig, trio trio trio')
   }
   else if ((i % 5 === 0) && (i % 3 !== 0)) {
     console.log('trio trio trio');
   }
   else if (i % 3 === 0) {
     console.log('Diglett dig');
   }else{
 console.log(i);
  }
 }
}
diglettDig();


//3. Funções por parâmetro!?
//Crie uma função chamada find que recebe um array e uma função por parâmetro.
//A função (passada por parâmetro) deverá informar um critério de busca de
//elementos dentro do array e a função find utilizará este critério para retornar todos
//elementos do array que encontram-se dentro dele. NÃO SURTEM! Exemplos:
function find (array,busca){
  var novoArray = new Array();

  for (var i = 0, len = array.length; i < len; i++) {
      if(typeof(busca) === 'function'){// Bônus Altere a implementação para apenas executar o segundo parâmetro caso ele seja uma função.
      if(busca(array[i])){
        novoArray.push(array[i]);
      }
      }
    }
      return novoArray;
};

var maiorIgualADois = function(elemento) {
  return elemento >= 2;
};
console.log(find([ 1, 2, 3 ], maiorIgualADois));// [ 2, 3 ]

console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
  return typeof elem === 'string';
}));
// [ 'a', 'false' ]

console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
  return typeof elem.nome === 'c';
}));
// []

//4. Você sabe subtrair?
//Crie uma função chamada subtrair que realiza a subtração de dois números em duas chamadas de funções diferentes.

//5. Igualdade recursiva
//Escreva uma função iguais que recebe dois parâmetros e retorna true apenas se os valores dos parâmetros forem iguais 
//ou se eles forem objetos com as mesmas propriedades com valores iguais e assim recursivamente 
//(ou seja, em até vários níveis de propriedades dentro dos objetos).

//6. Ctrl+Copyright
//Escreva uma função ctrlC que recebe um parâmetro e realiza a cópia de todos seus valores e retorne o resultado.

function ctrlC(original) {
  var copia = (original instanceof Array) ? [] : {}; // verificando se é um array ou um objeto 'comum' e instanciando a cópia
  for (i in original) { // iterando cada propriedade do objeto original
    if (original[i] && typeof original[i] == 'object') copia[i] = ctrlC(original[i]); // se for um objeto realiza cópia desse objeto (note a recursividade aqui)
    else copia[i] = original[i]; // se não simplesmente copia o valor
  }
  return copia; // retorna a cópia
};

var original = ctrlC({ a: '1' });
console.log(original);

var destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
console.log(destino.a[2].e());
// 3

//7. Mesclar
//Crie uma função chamada mesclar que recebe dois objetos como argumentos e mescla todas propriedades do segundo parâmetro dentro do primeiro.
function mesclar(obj1,obj2,parametro){
    if(parametro === true){ // Bônus 
        mesclar(obj1,obj2);
    }
    for(var property in obj2){
        obj1 = Object.assign(obj1, obj2);
    }
 return obj1;
}

var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
  damasco: 100
};
mesclar(objeto1, objeto2,true);
console.log(objeto1);