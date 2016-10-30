using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(int nivel)
        {
           if(nivel >= 1 || nivel <= 5)
            {
                Nivel = nivel;
            }
           else
            {
                Nivel = 2;
            }
        }
        public int Nivel { get; set; }
        public int Bonus
        {
            get
            {
               return Nivel;
            }
        }
    }
}
