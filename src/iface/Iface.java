package iface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Iface 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
                 
        System.out.println();
        System.out.print("              Bem vindo ao Iface!!\n");
        System.out.println();
        System.out.print("-Caso seja um novo membro, crie sua conta!!!\n-Caso já possua uma conta, efetue o login, e aproveite os recursos!!!");
        System.out.println();
        System.out.print("1 . Criação de Conta\n");
        System.out.print("2 . Criação/Edição de Perfil\n");
        System.out.print("3 . Adição de Amigos\n");
        System.out.print("4 . Envio/checagem de Mensagens\n");
        System.out.print("5 . Criação de Comunidades\n");
        System.out.print("6 . Adição de membros\n");
        System.out.print("7 . Recuperar Informações sobre Usuário\n");
        System.out.print("8 . Remoção de Conta\n");
        System.out.println();
    
        int possui = 0;
        int opcao = 0;
        int controle = 1;
        int cont = 0;
        int incorreto = 1;
        int cont_aux = 0;
        String lixo = new String();
        
        System.out.print("Já possui uma conta:\n SIM: Digite 1\n NÃO: Digite 0\nResp: ");
        while(cont_aux == 0)
        {
            try
            {
                possui = input.nextInt();
                cont_aux++;
            }
            catch(InputMismatchException Exception)
            {
                lixo = input.nextLine();
                System.out.println();
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nJá possui uma conta:\n SIM: Digite 1\n NÃO: Digite 0\nResp: ");
            }
        }   
        cont_aux = 0;
        
        System.out.println();
        
        if(possui == 0)
        {
            System.out.print("Crie sua nova conta, sendo o primeiro Usuário!...");
            opcao = 1;
            System.out.println();
        }
       
        lixo = input.nextLine();
        
        java.util.ArrayList<Usuario> Usuarios = new java.util.ArrayList<Usuario>();
        java.util.ArrayList<Comunidade> Comunidades = new java.util.ArrayList<Comunidade>();
        
        String login_user = null;
        
        Usuario user = new Usuario();
        
        while(opcao != 10)
        {
            if(possui == 0)
            {
                if(opcao == 1)
                {
                    while(controle == 1)
                    {
                        cont++;
                        
                        Usuario user_create = new Usuario();
                        
                        Usuarios = user_create.create_user(user_create, Usuarios, cont);
                        //user = Usuarios.get(Usuarios.size() - 1);
                        
                        System.out.println();
                        System.out.print("Deseja fazer login ou criar uma nova conta?\n Nova conta : Digite 1\n Login: Digite 2\nResp: ");
                        while(cont_aux == 0)
                        {
                            try
                            {
                                controle = input.nextInt();
                                cont_aux++;
                            }
                            catch(InputMismatchException Exception)
                            {
                                lixo = input.nextLine();
                                System.out.println();
                                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDeseja fazer login ou criar uma nova conta?\n Nova conta : Digite 1\n Login: Digite 2\nResp: ");
                            }
                        }   
                        cont_aux = 0;
                        lixo = input.nextLine();
                        System.out.println();
                    }
                }
            }
            if(possui == 1 && Usuarios.size() == 0)
            {
                System.out.print("Não há nenhum usuario cadastrado.\nPara se cadastrar Digite 0\nResp: ");
                while(cont_aux == 0)
                {
                    try
                    {
                        possui = input.nextInt();
                        cont_aux++;
                    }
                    catch(InputMismatchException Exception)
                    {
                        lixo = input.nextLine();
                        System.out.println();
                        System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nNão há nenhum usuario cadastrado.\nPara se cadastrar Digite 0\nResp: ");
                    }
                }   
                cont_aux = 0;
                System.out.println();
                opcao = 1;
            }
            if((possui == 1 || controle == 2) && (Usuarios.size() > 0))
            {
                int s, excluiu = 0;
                
                String login, senha;
                
                while(incorreto == 1)
                {
                    System.out.println("Digite seu login de usuário: ");
                    login = input.nextLine();

                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();

                    for(s = 0; s < Usuarios.size(); s++)
                    {
                        if(Usuarios.get(s).getLogin().equals(login) && Usuarios.get(s).getSenha().equals(senha))
                        {
                            login_user = Usuarios.get(s).getLogin();
                            user = Usuarios.get(s);
                            
                            System.out.println("Login efetuado com sucesso!!!\n");
                            System.out.print("2 . Criação/Edição de Perfil\n");
                            System.out.print("3 . Adição de Amigos\n");
                            System.out.print("4 . Envio/checagem de Mensagens\n");
                            System.out.print("5 . Criação de Comunidades\n");
                            System.out.print("6 . Adição de membros\n");
                            System.out.print("7 . Recuperar Informações sobre Usuário\n");
                            System.out.println("8 . Remoção de Conta\n");
                            System.out.print("Digite a opção que deseja escolher:\nResp: ");
                            while(cont_aux == 0)
                            {
                                try
                                {
                                    opcao = input.nextInt();
                                    cont_aux++;
                                }
                                catch(InputMismatchException Exception)
                                {
                                    lixo = input.nextLine();
                                    System.out.println();
                                    System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite a opção que deseja escolher:\nResp: ");
                                }
                            }   
                            cont_aux = 0;
                            System.out.println();
                            
                            lixo = input.nextLine();
                            incorreto = 0;
                            break;
                        }
                        else if(s == Usuarios.size() - 1)
                        {
                            System.out.println("Usuário não existe ou login e senha estão incorrentos...\nTente novamente\n");
                        }
                    }
                }
                if(opcao == 2)
                {
                    int op = 0, local;
                    String edit, create;
                    System.out.print("Digite a operação que deseja executar\n Criar: Digite 1\n Editar: Digite 2:\nResp: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            op = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite a operação que deseja executar\n Criar: Digite 1\n Editar: Digite 2:\nResp: ");
                        }
                    }   
                    cont_aux = 0;
                    System.out.println();
                    
                    lixo = input.nextLine();

                    if(op == 2)
                    {    
                        System.out.print("Digite qual atributo deseja editar(login, nome, senha)\nSe ja tiver criado, você pode editar também os seguintes tópicos(profissao, idade, hobby, idade, relacionamento)\nResp: ");
                        edit = input.nextLine();
                        System.out.println();
                        user = user.edit(user, edit);
                    }
                    if(op == 1)
                    {
                        System.out.print("Digite o nome do atributo que deseja criar (profissao, idade, hobby, cidade, relacionamento)\nResp: ");
                        create = input.nextLine();
                        System.out.println();
                        user = user.criar(user, create);
                    }
                    local = user.search_user(Usuarios, user.getLogin());
                    Usuarios.set(local, user);
                }   
                if(opcao == 3)
                {
                    int local;
                    int j, k, z, acao = 0;
                    String nome_amigo;
                    System.out.print("Você deseja mandar uma solicitação, ou checar as recebidas?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            acao = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja mandar uma solicitação, ou checar as recebidas?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                        }
                    }   
                    cont_aux = 0;
                    lixo = input.nextLine();
                    System.out.println();
                    if(acao == 1)
                    {
                        Usuarios = user.mandar_solicitacao(user, Usuarios, login_user);
                        local = user.search_user(Usuarios, user.getLogin());
                        user = Usuarios.get(local);
                    }
                    if(acao == 2)
                    {
                        Usuarios = user.checar_solicitacao(user, Usuarios);
                        local = user.search_user(Usuarios, user.getLogin());
                        user = Usuarios.get(local);
                    }
                }
                if(opcao == 4)
                {
                    int func = 0, geral = 0, op_comunidade = 0, control41 = 0, control42 = 0, local;
                    String nome_comunidade;
                    int g, d, a, i, j, q;
                    System.out.print("Você deseja mandar/checar mensagem para um usuário, ou para uma comunidade da qual participa?\n Usuario: Digite 1\n Comunidade: Digite 2\nResp: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            geral = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja mandar/checar mensagem para um usuário, ou para uma comunidade da qual participa?\n Usuario: Digite 1\n Comunidade: Digite 2\nResp: ");
                        }
                    }   
                    cont_aux = 0;
                    System.out.println();
                    if(geral == 1)
                    {
                        System.out.print("Você deseja mandar um nova mensagem, ou checar as recebidas?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                        while(cont_aux == 0)
                        {
                            try
                            {
                                func = input.nextInt();
                                cont_aux++;
                            }
                            catch(InputMismatchException Exception)
                            {
                                lixo = input.nextLine();
                                System.out.println();
                                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja mandar um nova mensagem, ou checar as recebidas?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                            }
                        }   
                        cont_aux = 0;
                        lixo = input.nextLine();
                        System.out.println();
                        if(func == 1)
                        {
                            Usuarios = user.mandar_msg(Usuarios, user);
                            local = user.search_user(Usuarios, user.getLogin());
                            user = Usuarios.get(local);
                        }
                        if(func == 2)
                        {
                            user.checar_msg(Usuarios, user);
                        }
                    }
                    if(geral == 2)
                    {
                        System.out.print("Você deseja mandar ou checar as mensagens da comunidade?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                        while(cont_aux == 0)
                        {
                            try
                            {
                                op_comunidade = input.nextInt();
                                cont_aux++;
                            }
                            catch(InputMismatchException Exception)
                            {
                                lixo = input.nextLine();
                                System.out.println();
                                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê deseja mandar ou checar as mensagens da comunidade?\n Mandar: Digite 1\n Checar: Digite 2\nResp: ");
                            }
                        }   
                        cont_aux = 0;
                        lixo = input.nextLine();
                        System.out.println();
                        
                        if(op_comunidade == 1)
                        {
                            Comunidade comunidade = new Comunidade();
                            Comunidades = comunidade.mandar_msg_comunidade(Comunidades, user);
                        }
                        if(op_comunidade == 2)
                        {
                            Comunidade comunidade = new Comunidade();
                            comunidade.checar_msg_comunidade(Comunidades, user);
                        }
                    }
                }
                if(opcao == 5)
                {
                    int local;
                    Comunidade c = new Comunidade();
                    Usuarios = c.create_comunidade(c, user, Usuarios);
                    local = user.search_user(Usuarios, user.getLogin());
                    user = Usuarios.get(local);
                    Comunidades.add(user.getComunidade());
                }
                if(opcao == 6)
                {
                    int go = 0;
                    System.out.print("Você pode entrar em uma comunidade ou checar pedidos para entrarem na sua comunidade\n Entrar: Digite 1\n Checar: Digite 2\nResp: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            go = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nVocê pode entrar em uma comunidade ou checar pedidos para entrarem na sua comunidade\n Entrar: Digite 1\n Checar: Digite 2\nResp: ");
                        }
                    }   
                    cont_aux = 0;
                    System.out.println();
                    
                    lixo = input.nextLine();
                    
                    if(go == 1) 
                    {
                        int local;
                        Comunidade c = new Comunidade();
                        Comunidades = c.entrar_comunidade(Comunidades, Usuarios, user);
                        local = user.search_user(Usuarios, user.getLogin());
                        user = Usuarios.get(local);
                    }
                    if(go == 2)
                    {
                        int local;
                        Comunidade c = new Comunidade();
                        Comunidades = c.checar_comunidade(Comunidades, Usuarios, user);
                        local = user.search_user(Usuarios, user.getLogin());
                        user = Usuarios.get(local);
                    }
                }
                if(opcao == 7)
                {
                    user.info(user);
                }
                if(opcao == 8)
                {
                    excluiu = user.removing(Usuarios, Comunidades, user);
                }
                //------------------------------------------------------------------------------------------------------
                System.out.println();
                int reinicio = 0;
                if(opcao != 8 || (opcao == 8 && excluiu == 0))
                {
                    System.out.println("-Caso deseje executar um nova operação com este mesmo usuario, digite 1.");
                    System.out.println("-Caso deseje utilizar outro usuário, digite 2.");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            reinicio = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\n-Caso deseje executar um nova operação com este mesmo usuario, digite 1.\n-Caso deseje utilizar outro usuário, digite 2.");
                        }
                    }   
                    cont_aux = 0;
                    lixo = input.nextLine();
                }
                if(opcao == 8 && excluiu == 1)
                {
                    reinicio = 2;
                }
                if(reinicio == 1)
                {
                    System.out.println();
                    System.out.print("2 . Criação/Edição de Perfil\n");
                    System.out.print("3 . Adição de Amigos\n");
                    System.out.print("4 . Envio/checagem de Mensagens\n");
                    System.out.print("5 . Criação de Comunidades\n");
                    System.out.print("6 . Adição de membros\n");
                    System.out.print("7 . Recuperar Informações sobre Usuário\n");
                    System.out.println("8 . Remoção de Conta\n");
                    System.out.print("Digite a nova opcao que deseja executar\nOpção: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            opcao = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDigite a nova opcao que deseja executar\nOpção: ");
                        }
                    }   
                    cont_aux = 0;
                    System.out.println();
                    
                    if(opcao == 5)
                    {
                        lixo = input.nextLine();
                    }
                }
                if(reinicio == 2)
                {
                    System.out.println();
                    System.out.print("Caso seja a primeira vez deste usuario, você precisará criar um nova conta.\n Já possui uma conta:\n SIM: Digite 1\n NÃO: Digite 0\n Resp: ");
                    while(cont_aux == 0)
                    {
                        try
                        {
                            possui = input.nextInt();
                            cont_aux++;
                        }
                        catch(InputMismatchException Exception)
                        {
                            lixo = input.nextLine();
                            System.out.println();
                            System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nCaso seja a primeira vez deste usuario, você precisará criar um nova conta.\n Já possui uma conta:\n SIM: Digite 1\n NÃO: Digite 0\n Resp: ");
                        }
                    }   
                    cont_aux = 0;
                    if(possui == 0)
                    {
                        System.out.println();
                        System.out.print("Se deseja criar uma nova conta, digite 1\n Resp: ");
                        while(cont_aux == 0)
                        {
                            try
                            {
                                opcao = input.nextInt();
                                cont_aux++;
                            }
                            catch(InputMismatchException Exception)
                            {
                                lixo = input.nextLine();
                                System.out.println();
                                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nSe deseja criar uma nova conta, digite 1\n Resp: ");
                            }
                        }   
                        cont_aux = 0;
                        
                        lixo = input.nextLine();
                        
                        controle = 1;
                        incorreto = 1;
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Faça seu login");
                        System.out.println();
                        lixo = input.nextLine();
                        
                        incorreto = 1;
                    }
                }
            }
        }           
    }
}
