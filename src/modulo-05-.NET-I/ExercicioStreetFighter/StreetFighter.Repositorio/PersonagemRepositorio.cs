using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();
        //const string CaminhoArquivo = @"C:\Users\jeniffer.costa\Documents\github\crescer-2016-2\src\modulo-05-.NET-I\ExercicioStreetFighter\StreetFighter.Repositorio\BaseDeDados\ListaDePersonagens.csv";
        const string CaminhoArquivo = @"C:\Users\diiego\Desktop\github\crescer-2016-2\src\modulo-05-.NET-I\ExercicioStreetFighter\StreetFighter.Repositorio\BaseDeDados\ListaDePersonagens.csv";
        public PersonagemRepositorio()
        {

        }

        public void AdicionarPersonagem(Personagem personagem)
        {
            var UltimoID = File.ReadAllLines(CaminhoArquivo).Length;
            personagem.Id = UltimoID + 1;

            File.AppendAllText(CaminhoArquivo, Environment.NewLine + personagem.ToString());

        }

        public void AdicionarPersonagemSQL(Personagem personagem)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighter"].ConnectionString;

            List<Personagem> result = new List<Personagem>();

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "";
                    var parameters = new List<SqlParameter>();

                    if (personagem.Id > 0)
                    {
                        sql = $"UPDATE Personagem SET Nome=@param_nome, DataNascimento=@param_dataNascimento, Altura=@param_altura, Peso=@param_peso, Origem=@param_origem, Imagem=@param_imagem, GolpesEspeciais=@param_golpesEspeciais, PersonagemOculto=@param_personagemOculto  WHERE Id = @param_id";

                        parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_dataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                        parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_golpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                        parameters.Add(new SqlParameter("param_id", personagem.Id));
                    }
                    else
                    {
                        sql = $"INSERT INTO Personagem (Nome,DataNascimento,Altura,Peso,Origem,Imagem,GolpesEspeciais,PersonagemOculto) values (@param_nome,@param_dataNascimento,@param_altura,@param_peso,@param_origem,@param_imagem,@param_golpesEspeciais,@param_personagemOculto)";
                        parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_dataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                        parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_golpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                    }

                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (Exception ex)
                {
                    //... 
                }
                finally
                {
                    connection.Close();
                }

            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            int indexDoPersonagem = Personagens.FindIndex(p => p.Id == personagem.Id);
            Personagens.RemoveAt(indexDoPersonagem);
            Personagens.Insert(indexDoPersonagem, personagem);
            File.WriteAllLines(CaminhoArquivo, Personagens.Select(p => p.ToString()));

        }

        public void EditarPersonagemSQL(Personagem personagem)
        {
            this.AdicionarPersonagemSQL(personagem);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            var listaDePersonagens = ListarPersonagens(null);

            personagem = listaDePersonagens.Find(x => x.Id == personagem.Id);

            var file = new List<string>(System.IO.File.ReadAllLines(@"C: \Users\diiego\Documents\Visual Studio 2015\Projects\StreetFighter.Web\StreetFighter.Repositorio\BaseDeDados\ListaDePersonagens.csv"));

            file.RemoveAt(personagem.Id);
            File.WriteAllLines(@"C: \Users\diiego\Documents\Visual Studio 2015\Projects\StreetFighter.Web\StreetFighter.Repositorio\BaseDeDados\ListaDePersonagens.csv", file.ToArray());

        }

        public void ExcluirPersonagemSQL(int id)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighter"].ConnectionString;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"DELETE FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", $"{id}"));

                SqlDataReader reader = command.ExecuteReader();

                connection.Close();
            }
        }

        public List<Personagem> ListarPersonagens(string filtro)
        {
            var lista = new List<Personagem>();
            var personagens = File.ReadLines(CaminhoArquivo);

            foreach (var item in personagens)
            {
                var parametros = item.Split(';');
                var ptBR = new CultureInfo("pt-BR", false).DateTimeFormat;

                var personagem = new Personagem(Convert.ToInt32(parametros[0]),
                                                parametros[1],
                                                Convert.ToDateTime(parametros[2], ptBR),
                                                Convert.ToInt32(parametros[3]),
                                                Convert.ToDecimal(parametros[4]),
                                                parametros[5],
                                                parametros[6],
                                                parametros[7],
                                                Convert.ToBoolean(parametros[8]));

                if (filtro == null || personagem.Nome.Contains(filtro))
                    lista.Add(personagem);
            }

            return lista;
        }

        public Personagem BuscarPorId(int id)
        {
            List<Personagem> personagens = this.ListarPersonagens(null);

            return personagens.Find(personagem => personagem.Id == id);
        }

        public Personagem BuscarPorIdSQL(int id)
        {
            Personagem personagem = null;
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighter"].ConnectionString;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id = @param_id";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_id", $"{id}"));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    personagem = new Personagem(
                         Convert.ToInt32(reader["Id"]), 
                         reader["Nome"].ToString(), 
                         Convert.ToDateTime(reader["DataNascimento"]),
                         Convert.ToInt32(reader["Altura"]),
                         Convert.ToDecimal(reader["Peso"]),
                         reader["Origem"].ToString(),
                         reader["Imagem"].ToString(),
                         reader["GolpesEspeciais"].ToString(),
                        Convert.ToBoolean(reader["PersonagemOculto"]));
                }

                connection.Close();
            }
            return personagem;
        }

        public List<Personagem> ListarPersonagensSQL(string filtro)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighter"].ConnectionString;

            List<Personagem> result = new List<Personagem>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_nome";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_nome", $"%{filtro}%"));

                SqlDataReader reader = command.ExecuteReader();

                while(reader.Read())
                {
                    Personagem found = ConvertReaderPersonagem(reader);
                    result.Add(found);
                }

                connection.Close();
            }
            return result;
        }

        private Personagem ConvertReaderPersonagem(SqlDataReader reader)
        {
            Personagem retorno = new Personagem(
                   id: Convert.ToInt32(reader["id"]),
                   nome: Convert.ToString(reader["nome"]),
                   dataNascimento: Convert.ToDateTime(reader["dataNascimento"]),
                   altura: Convert.ToInt32(reader["altura"]),
                   peso: Convert.ToDecimal(reader["peso"]),
                   origem: Convert.ToString(reader["origem"]),
                   imagem: Convert.ToString(reader["imagem"]),
                   golpesEspeciais: Convert.ToString(reader["golpesEspeciais"]),
                   personagemOculto: Convert.ToBoolean(reader["personagemOculto"])
                );
            return retorno;
        }
    }
}
