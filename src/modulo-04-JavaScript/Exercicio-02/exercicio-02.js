//01. Heróis com classe
//Crie uma classe Herois que recebe no seu construtor um array com as informações dos personagens. 
//Exemplo (sem todas propriedades dos personagens, para exemplo completo olhar o arquivo baixado acima):

class Herois {
   constructor(array) {
        this.arrayDePersonagens = new Array();
        for (let prop in array) {
            this.arrayDePersonagens.push(array[prop]);
        }
    }


//02. Fora da guerra civíl
//Escreva um método foraDaGuerraCivil() de instância da classe Herois que retorna um array com todos aqueles 
//personagens que NÃO participaram da guerra civíl.
//Para saber quando um personagem participou da guerra civíl, basta procurar no seu array events por algum 
//item que tenha 'Civil War' dentro da string.
foraDaGuerraCivil() { 
  this.naoParticiparamDaGuerra = [];
    for (let prop in this.arrayDePersonagens) {
            let eventos = this.arrayDePersonagens[prop].events.items;
            let naoParticipou = true;
            for (let key in eventos) {
                let itemEvento = eventos[key];
                if (itemEvento.name === "Civil War") {
                    naoParticipou = false;
                }
            }
            if (naoParticipou) {
                this.naoParticiparamDaGuerra.push(this.arrayDePersonagens[prop]);
            }
        }
        return this.naoParticiparamDaGuerra;
    }
}

