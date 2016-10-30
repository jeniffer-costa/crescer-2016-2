using ExercicioMarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor Corredor) : base(Corredor)
        {

        }

        public override int Velocidade
        {
            get
            {
                bool PossuiEquipamento = VerificarSePossuiEquipamentos();
               
                if (PossuiEquipamento)
                {
                    return base.Velocidade =+ 2;
                }
                return base.Velocidade;
            }
        }

        protected virtual bool VerificarSePossuiEquipamentos()
        {
            bool PossuiEquipamentos = false;

            if(this.Equipamentos.Count > 0)
            {
                PossuiEquipamentos = true;
            }

            return PossuiEquipamentos;
        }
    }
}
