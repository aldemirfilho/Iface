package iface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Usuario 
{
    private int id;
    private String login;
    private String senha;
    private String nome;
    private String profissao;
    private int idade;
    private String hobby;
    private String cidade;
    private String Relacionamento;
    private Comunidade comunidade;
    
    Scanner input = new Scanner(System.in);
    
    java.util.ArrayList<String> comunidades_part = new java.util.ArrayList<String>();
    
    java.util.ArrayList<String> Amigos = new java.util.ArrayList<String>();
    
    java.util.ArrayList<String> Pedidos_Amigos = new java.util.ArrayList<String>();
    
    java.util.ArrayList<ArrayList<String>> mensagens = new  java.util.ArrayList<ArrayList<String>>();
    
    java.util.ArrayList<String> new_mensagens = new java.util.ArrayList<String>();
    
    public int search_user(java.util.ArrayList<Usuario> Usuarios, String login)
    {
        int z, local = 0;
        for (z = 0; z < Usuarios.size(); z++) 
        {
            if(Usuarios.get(z).getLogin().equals(login))
            {
                local = z;
            }
        }
        return local;
    }
    
    public int removing(java.util.ArrayList<Usuario> Usuarios, java.util.ArrayList<Comunidade> Comunidades, Usuario user)
    {
        int cont_aux = 0;
        String comunidade_dono_nome = null, lixo;
        int excluir = 0, i, j, k, g, d, f, e, x, n, m, l, y, w, excluiu = 0;
        System.out.print("Você deseja excluir sua conta e todos os seus dados?\n SIM: Digite 1\n NÃO: Digite 0\n Resp: ");
        while(cont_aux == 0)
        {
            try
            {
                excluir = input.nextInt();
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja excluir sua conta e todos os seus dados?\n SIM: Digite 1\n NÃO: Digite 0\n Resp: ");
            }
        }   
        cont_aux = 0;
        System.out.println();
        if (excluir == 1) {
            for (f = 0; f < Comunidades.size(); f++) {
                for (e = 0; e < Comunidades.get(f).getMembros().size(); e++) {
                    if (Comunidades.get(f).getMembros().get(e).equals(user.getLogin())) {
                        for (w = 0; w < Comunidades.get(f).getMensagens().size(); w++) {
                            if (Comunidades.get(f).getMensagens().get(w).getNome_user().equals(user.getLogin())) {
                                Comunidades.get(f).getMensagens().remove(w);
                            }
                        }
                        Comunidades.get(f).getMembros().remove(e);
                    }
                }
                for (x = 0; x < Comunidades.get(f).getPedidos().size(); x++) {
                    if (Comunidades.get(f).getPedidos().get(x).equals(user.getLogin())) {
                        Comunidades.get(f).getPedidos().remove(x);
                    }
                }
            }
            for (m = 0; m < Comunidades.size(); m++) {
                if (Comunidades.get(m).getAdmin().equals(user.getComunidade().getAdmin())) {
                    comunidade_dono_nome = user.getComunidade().getNome_comunidade();
                    for (l = 0; l < Usuarios.size(); l++) {
                        for (y = 0; y < Usuarios.get(l).getComunidades_part().size(); y++) {
                            if (Usuarios.get(l).getComunidades_part().get(y).equals(comunidade_dono_nome)) {
                                Usuarios.get(l).getComunidades_part().remove(y);
                            }
                        }
                    }
                    Comunidades.remove(m);
                }
            }
            for (i = 0; i < Usuarios.size(); i++) {
                for (j = 0; j < Usuarios.get(i).getAmigos().size(); j++) {
                    if (Usuarios.get(i).getAmigos().get(j).equals(user.getLogin())) {
                        Usuarios.get(i).getAmigos().remove(j);
                    }
                }
                for (k = 0; k < Usuarios.get(i).getPedidos_Amigos().size(); k++) {
                    if (Usuarios.get(i).getPedidos_Amigos().get(k).equals(user.getLogin())) {
                        Usuarios.get(i).getPedidos_Amigos().remove(k);
                    }
                }
                for (g = 0; g < Usuarios.get(i).getNew_mensagens().size(); g++) {
                    if (Usuarios.get(i).getNew_mensagens().get(g).equals(user.getLogin())) {
                        Usuarios.get(i).getNew_mensagens().remove(g);
                    }
                }
                for (d = 0; d < Usuarios.get(i).getMensagens().size(); d++) {
                    if (Usuarios.get(i).getMensagens().get(d).get(0).equals(user.getLogin())) {
                        Usuarios.get(i).getMensagens().remove(d);
                    }
                }
            }
            for (n = 0; n < Usuarios.size(); n++) {
                if (Usuarios.get(n).getLogin().equals(user.getLogin())) {
                    Usuarios.remove(n);
                    System.out.println("Usuário excluido com sucesso!");
                }
            }
            excluiu = 1;
        }
        if (excluir == 0) {
            System.out.println("Conta não excluída");
        }
        return excluiu;
    }
    
    public void info(Usuario user)
    {
        int entrada = 0, j, i, cont_aux = 0;
        String lixo;
        System.out.print("Caso deseje ver informaçoes sobre o seu perfil, Digite 1.\nCaso deseje ver as mensagens trocadas com um amigo especifico, Digite 2.\nResp: ");
        while(cont_aux == 0)
        {
            try
            {
                entrada = input.nextInt();
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nCaso deseje ver informaçoes sobre o seu perfil, Digite 1.\nCaso deseje ver as mensagens trocadas com um amigo especifico, Digite 2.\nResp: ");
            }
        }   
        cont_aux = 0;
        System.out.println();

        if (entrada == 1) {
            System.out.println("Nome: " + user.getNome() + ".");
            System.out.println("Nome de Login: " + user.getLogin() + ".");
            if (user.getProfissao() == null) {
                System.out.println("Você pode atualizar a categoria Profissão, na opção 2, basta criar.");
            } else {
                System.out.println("Profissão: " + user.getProfissao() + ".");
            }
            if (user.getIdade() != 0) {
                System.out.println("Idade: " + user.getIdade() + " anos.");
            } else {
                System.out.println("Você pode atualizar a categoria Idade, na opção 2, basta criar.");
            }
            if (user.getHobby() == null) {
                System.out.println("Você pode atualizar a categoria Hobby, na opção 2, basta criar.");
            } else {
                System.out.println("Hobby: " + user.getHobby() + ".");
            }
            if (user.getCidade() == null) {
                System.out.println("Você pode atualizar a categoria Cidade, na opção 2, basta criar.");
            } else {
                System.out.println("Cidade: " + user.getCidade() + ".");
            }
            if (user.getRelacionamento() == null) {
                System.out.println("Você pode atualizar a categoria Relacionamento, na opção 2, basta criar.");
            } else {
                System.out.println("Relacionamento: " + user.getRelacionamento() + ".");
            }
            System.out.println();
            System.out.println("Comunidades nas quais participa: ");
            for (j = 0; j < user.getComunidades_part().size(); j++) {
                System.out.println("-" + user.getComunidades_part().get(j));
            }
            System.out.println();
            System.out.println("Amigos: ");
            for (i = 0; i < user.getAmigos().size(); i++) {
                System.out.println("-" + user.getAmigos().get(i));
            }
        }
        if (entrada == 2) {
            lixo = input.nextLine();

            int q, r, encontrado = 0;
            String cidadao;
            if(user.getAmigos().size() > 0)
            {
                System.out.println("Digite o nome de quem você deseja ver as mensagens trocadas: ");
                cidadao = input.nextLine();
                for (q = 0; q < user.getMensagens().size(); q++) {
                    if (user.getMensagens().get(q).get(0).equals(cidadao)) {
                        for (r = 1; r < user.getMensagens().get(q).size(); r++) {
                            System.out.println(user.getMensagens().get(q).get(r));
                        }
                        encontrado = 1;
                    }
                    if ((q == user.getMensagens().size() - 1) && (encontrado == 0)) {
                        System.out.println("Uuario desejado não encontrado. Ou não existe, ou foi digitado incorretamente...");
                    }
                }
            }
            else
            {
                System.out.println("Você ainda não tem amigos");
            }
        }
    }
    
    public java.util.ArrayList<Usuario> mandar_msg(java.util.ArrayList<Usuario> Usuarios, Usuario user)
    {
        String destinatario, mensagem;
        int control = 0, g, local, j;
        System.out.println("Usuários ativos:");
        for (j = 0; j < Usuarios.size(); j++) 
        {
            if(!(Usuarios.get(j).getLogin().equals(user.getLogin())))
                System.out.println("-" + Usuarios.get(j).getLogin());
        }
        System.out.println("Digite o nome de login para quem você deseja mandar mensasgem");
        destinatario = input.nextLine();
        System.out.println("Digite a mensagem que deseja enviar, siga este formato (SEU_LOGIN: Mensagem)");
        mensagem = input.nextLine();

        local = user.search_user(Usuarios, user.getLogin());

        java.util.ArrayList<String> pessoas2 = new java.util.ArrayList<String>();

        for (g = 0; g < Usuarios.size(); g++) {
            pessoas2 = Usuarios.get(local).getMensagens().get(g);

            if (pessoas2.get(0).equals(destinatario)) {
                pessoas2.add(mensagem);
                Usuarios.get(local).getMensagens().set(g, pessoas2);
                System.out.println();
                System.out.println("Mensagem enviada ao destinatario");
                control = 1;
                break;
            } else if ((g == Usuarios.size() - 1) && control == 0) {
                System.out.println();
                System.out.println("Usuario de destino não encontrado, tente novamente...");
            }
        }
        control = 0;
        int d;
        for (d = 0; d < Usuarios.size(); d++) {
            if (Usuarios.get(d).getLogin().equals(destinatario)) {
                java.util.ArrayList<String> pessoas3 = new java.util.ArrayList<String>();
                for (g = 0; g < Usuarios.size(); g++) {
                    pessoas3 = Usuarios.get(d).getMensagens().get(g);
                    if (pessoas3.get(0).equals(user.getLogin())) {
                        pessoas3.add(mensagem);
                        Usuarios.get(d).getNew_mensagens().add(user.getLogin());
                        Usuarios.get(d).getMensagens().set(g, pessoas3);
                        System.out.println();
                        System.out.println("Notificaçao guardada para o destinatario");
                        control = 1;
                        break;
                    }
                }
            } else if ((d == Usuarios.size() - 1) && control == 0) {
                System.out.println();
                System.out.println("Notificação não foi enviada com sucecsso, possivel erro na digitação do destinatário");
            }
        }
        return Usuarios;
    }
    
    public void checar_msg(java.util.ArrayList<Usuario> Usuarios, Usuario user)
    {
        int g, d, a;
        String remetente;
        System.out.println("Você tem mensagens de: ");
        if (user.getNew_mensagens().size() != 0) 
        {
            for (g = 0; g < user.getNew_mensagens().size(); g++) 
            {
                System.out.println(user.getNew_mensagens().get(g));
            }
            System.out.println("Digite o nome de quem você deseja visualizar a mensagem: ");
            remetente = input.nextLine();
            for (d = 0; d < Usuarios.size(); d++) 
            {
                if (user.getMensagens().get(d).get(0).equals(remetente)) 
                {
                    for (g = 1; g < user.getMensagens().get(d).size(); g++) 
                    {
                        System.out.println(user.getMensagens().get(d).get(g));
                        for (a = 0; a < user.getNew_mensagens().size(); a++) 
                        {
                            if (user.getNew_mensagens().get(a).equals(remetente)) 
                            {
                                user.getNew_mensagens().remove(a);
                            }
                        }
                    }
                }
            }
        } 
        else 
        {
            System.out.println("Não há mensagens novas.");
        }
    }
    
    public java.util.ArrayList<Usuario> create_user(Usuario user_create, java.util.ArrayList<Usuario> Usuarios, int cont)
    {
        int diff = 0, z, x, control;
        while(diff == 0)
        {
            control = 0;
            System.out.println("Digite um login para acessar a conta posteriormente: ");
            user_create.setLogin(input.nextLine());
            if(Usuarios.size() == 0)
            {
                diff = 1;
            }
            else
            {
                for (z = 0; z < Usuarios.size(); z++) 
                {
                    if(Usuarios.get(z).getLogin().equals(user_create.getLogin()))
                    {
                        System.out.println("Este Login ja está sendo utilizado!! Tente outro.");
                        System.out.println();
                        control = 1;
                    }
                    if((z == Usuarios.size() - 1) && (control == 0))
                    {
                        diff = 1;
                    }
                }
            }
        }
        System.out.println("Digite sua senha: ");
        user_create.setSenha(input.nextLine());
        System.out.println("Digite o nome como você será conhecido na rede:");
        user_create.setNome(input.nextLine());
        user_create.setId(cont);
        Usuarios.add(user_create);

        for (z = 0; z < Usuarios.size(); z++) {
            java.util.ArrayList<String> pessoas = new java.util.ArrayList<String>();
            pessoas.add(Usuarios.get(z).getLogin());
            user_create.getMensagens().add(pessoas);
        }

        for (x = 0; x < Usuarios.size() - 1; x++) {
            java.util.ArrayList<String> pessoas = new java.util.ArrayList<String>();
            pessoas.add(Usuarios.get(Usuarios.size() - 1).getLogin());
            Usuarios.get(x).getMensagens().add(pessoas);
        }
        return Usuarios;
    }
    
    public Usuario edit(Usuario user, String edit)
    {
        int cont_aux = 0;
        String lixo;
        if (edit.equals("login")) {
            System.out.println("Digite o novo login: ");
            user.setLogin(input.nextLine());
        } else if (edit.equals("nome")) {
            System.out.println("Digite o seu novo nome: ");
            user.setNome(input.nextLine());
        } else if (edit.equals("senha")) {
            System.out.println("Digite sua nova senha: ");
            user.setSenha(input.nextLine());
        } else if (edit.equals("profissao")) {
            System.out.println("Digite sua nova profissão: ");
            user.setProfissao(input.nextLine());
        } else if (edit.equals("idade")) {
            System.out.println("Digite sua idade: ");
            while(cont_aux == 0)
            {
                try
                {
                    user.setIdade(input.nextInt());
                    cont_aux++;
                }
                catch(InputMismatchException Exception)
                {
                    lixo = input.nextLine();
                    System.out.println();
                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite sua idade: ");
                }
            }   
            cont_aux = 0;
        } else if (edit.equals("hobby")) {
            System.out.println("Digite seu hobby: ");
            user.setHobby(input.nextLine());
        } else if (edit.equals("cidade")) {
            System.out.println("Digite sua cidade: ");
            user.setCidade(input.nextLine());
        } else if (edit.equals("relacionamento")) {
            System.out.println("Digite seu status de relacionamento: ");
            user.setRelacionamento(input.nextLine());
        }
        return user;
    }
    
    public Usuario criar(Usuario user, String create)
    {
        int cont_aux = 0;
        String lixo;
        if (create.equals("profissao")) {
            System.out.println("Digite sua profissão: ");
            user.setProfissao(input.nextLine());
        } else if (create.equals("idade")) {
            System.out.println("Digite sua idade: ");
            while(cont_aux == 0)
            {
                try
                {
                    user.setIdade(input.nextInt());
                    cont_aux++;
                }
                catch(InputMismatchException Exception)
                {
                    lixo = input.nextLine();
                    System.out.println();
                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite sua idade: ");
                }
            }   
            cont_aux = 0;
        } else if (create.equals("hobby")) {
            System.out.println("Digite seu hobby: ");
            user.setHobby(input.nextLine());
        } else if (create.equals("cidade")) {
            System.out.println("Digite sua cidade: ");
            user.setCidade(input.nextLine());
        } else if (create.equals("relacionamento")) {
            System.out.println("Digite seu status de relacionamento: ");
            user.setRelacionamento(input.nextLine());
        }
        return user;
    }
    
    public java.util.ArrayList<Usuario> mandar_solicitacao(Usuario user, java.util.ArrayList<Usuario> Usuarios, String login_user)
    {
        int incorreto = 1;
        int control3 = 0, j;
        String nome_amigo;
        System.out.println("Usuários ativos:");
        for (j = 0; j < Usuarios.size(); j++) 
        {
            if(!(Usuarios.get(j).getLogin().equals(user.getLogin())))
                System.out.println("-" + Usuarios.get(j).getLogin());
        }
        System.out.println("Digite o nome de login de quem você quer adicionar como amigo: ");
        nome_amigo = input.nextLine();

        for (j = 0; j < user.getAmigos().size(); j++) 
        {
            if (user.getAmigos().get(j).equals(nome_amigo))
            {
                incorreto = 0;
                System.out.println("Vocês já são amigos");
            }
        }
        while (incorreto == 1) 
        {
            for (j = 0; j < Usuarios.size(); j++) 
            {
                if (Usuarios.get(j).getLogin().equals(nome_amigo)) 
                {
                    //System.out.println("euuu " + login_user);
                    Usuarios.get(j).getPedidos_Amigos().add(login_user);
                    System.out.println("Solicitação enviada!!");
                    incorreto = 0;
                    control3 = 1;
                    //System.out.println("nomes na lista de pedidos de amigos " + user3.getPedidos_Amigos());
                    break;
                } 
                else if (j == (Usuarios.size() - 1) && (control3 == 0)) 
                {
                    System.out.println("Usuário procurado não encontrado! Tente novamente");
                    incorreto = 0;
                }
            }
        }
        return Usuarios;
    }
    
    public java.util.ArrayList<Usuario> checar_solicitacao(Usuario user, java.util.ArrayList<Usuario> Usuarios)
    {
        int resp = 0, j, k, indice_user = 0, cont_aux = 0;
        String nome_amigo, lixo;
                        
        //System.out.println("LOGIN" + user.getLogin());
        if(user.getPedidos_Amigos().size() != 0)
        {
            for(j = 0; j < user.getPedidos_Amigos().size(); j++)
            {
                System.out.print("Você deseja aceitar " + user.getPedidos_Amigos().get(j) + "?\nSIM: Digite 1\nNAO: Digite 2\nResp: ");
                while(cont_aux == 0)
                {
                    try
                    {
                        resp = input.nextInt();
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja aceitar " + user.getPedidos_Amigos().get(j) + "?\nSIM: Digite 1\nNAO: Digite 2\nResp: ");
                    }
                }   
                cont_aux = 0;
                lixo = input.nextLine();
                System.out.println();
                                    
                nome_amigo = user.getPedidos_Amigos().get(j);
                //System.out.println("nome amigo " + nome_amigo);
                                   
                if(resp == 1)
                {
                    //System.out.println("nome userrr " + user.getLogin());
                    for(k = 0; k < Usuarios.size(); k++)
                    {
                        if(Usuarios.get(k).getLogin().equals(user.getLogin()))
                        {
                            Usuarios.get(k).getAmigos().add(nome_amigo);
                            indice_user = k;
                        }
                        if(Usuarios.get(k).getLogin().equals(nome_amigo))
                        {
                            Usuarios.get(k).getAmigos().add(user.getLogin());
                        }
                    }
                    Usuarios.get(indice_user).getPedidos_Amigos().remove(j);
                    j--;
                }
                else if(resp == 2)
                {
                    for(k = 0; k < Usuarios.size(); k++)
                    {
                        if(Usuarios.get(k).getLogin().equals(user.getLogin()))
                        {
                            indice_user = k;
                        }
                    }
                    Usuarios.get(indice_user).getPedidos_Amigos().remove(j);
                    j--;
                }
            }
        }
        else
        {
            System.out.println("Não a pedidos pendentes!");
        }
        return Usuarios;
    }

    public ArrayList<String> getComunidades_part() {
        return comunidades_part;
    }

    public void setComunidades_part(ArrayList<String> comunidades_part) {
        this.comunidades_part = comunidades_part;
    }

    public String getRelacionamento() {
        return Relacionamento;
    }

    public void setRelacionamento(String Relacionamento) {
        this.Relacionamento = Relacionamento;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public ArrayList<String> getNew_mensagens() {
        return new_mensagens;
    }

    public void setNew_mensagens(ArrayList<String> new_mensagens) {
        this.new_mensagens = new_mensagens;
    }

    public ArrayList<ArrayList<String>> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<ArrayList<String>> mensagens) {
        this.mensagens = mensagens;
    }

    public ArrayList<String> getPedidos_Amigos() {
        return Pedidos_Amigos;
    }

    public void setPedidos_Amigos(ArrayList<String> Pedidos_Amigos) {
        this.Pedidos_Amigos = Pedidos_Amigos;
    }

    public ArrayList<String> getAmigos() {
        return Amigos;
    }

    public void setAmigos(ArrayList<String> Amigos) {
        this.Amigos = Amigos;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
