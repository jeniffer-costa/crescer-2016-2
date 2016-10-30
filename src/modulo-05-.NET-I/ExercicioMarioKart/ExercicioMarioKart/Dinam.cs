using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Dinam : Kart
    {
        public Dinam(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                var BonusKArt = 3;
                var BonusHabilidadeCorredor = this.SomarBonusHabilidadeCorredor();
                var BonusPorEquipamento = SomarBonusEquipamentos();
                return (BonusHabilidadeCorredor * 2) + BonusKArt + BonusPorEquipamento;


            }
        }
    }
}
