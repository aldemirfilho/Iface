package iface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Comunidade 
{
    String nome_comunidade;
    String descricao;
    String admin;
    String status;
    
    Scanner input = new Scanner(System.in);
    
    java.util.ArrayList<String> Membros = new java.util.ArrayList<String>();
    java.util.ArrayList<String> pedidos = new java.util.ArrayList<String>();
    java.util.ArrayList<MsgComunidade> mensagens = new java.util.ArrayList<MsgComunidade>();

    public java.util.ArrayList<Comunidade> entrar_comunidade(java.util.ArrayList<Comunidade> Comunidades, java.util.ArrayList<Usuario> Usuarios, Usuario user)
    {
        int i6, f, control6 = 0, presenca = 0, local;
        String escolha;
        System.out.println("Essas são as comunidades disponiveis:");
        for (i6 = 0; i6 < Comunidades.size(); i6++) 
        {
            System.out.println(Comunidades.get(i6).getNome_comunidade() + " - " + Comunidades.get(i6).getStatus());
        }
        System.out.println("Digite a comunidade que deseja participar: ");
        escolha = input.nextLine();
        for (i6 = 0; i6 < Comunidades.size(); i6++) {
            if (Comunidades.get(i6).getNome_comunidade().equals(escolha)) {
                for (f = 0; f < Comunidades.get(i6).getMembros().size(); f++) {
                    if (Comunidades.get(i6).getMembros().get(f).equals(user.getLogin())) {
                        presenca = 1;
                    }
                }
                if (presenca == 0) {
                    if (Comunidades.get(i6).getStatus().equals("publico")) {
                        Comunidades.get(i6).getMembros().add(user.getLogin());
                        local = user.search_user(Usuarios, user.getLogin());
                        Usuarios.get(local).getComunidades_part().add(Comunidades.get(i6).getNome_comunidade());
                        System.out.println("Bem vindo a comunidade " + Comunidades.get(i6).getNome_comunidade() + "!!!");
                    }
                    if (Comunidades.get(i6).getStatus().equals("privado")) {
                        Comunidades.get(i6).getPedidos().add(user.getLogin());
                        System.out.println("Você entrará assim que o administrador aceitar seu pedido");
                    }
                    control6 = 1;
                }
                if (presenca == 1) {
                    System.out.println("Você já faz parte desta comunidade");
                    control6 = 1;
                    presenca = 0;
                }
            } else if ((i6 == Comunidades.size() - 1) && (control6 == 0)) {
                System.out.println("Nome da comunidade digitado incorretamente...");
            }
        }
        return Comunidades;
    }
    
    public java.util.ArrayList<Comunidade> checar_comunidade(java.util.ArrayList<Comunidade> Comunidades, java.util.ArrayList<Usuario> Usuarios, Usuario user)
    {
        int w, v, y, h, q, control62 = 0, resp = 0, local, cont_aux = 0;
        String comunidade_escolha, novo_membro, lixo;
        System.out.println("Comunidades existentes:");
        for (q = 0; q < Comunidades.size(); q++) {
            System.out.println(Comunidades.get(q).getNome_comunidade());
        }
        System.out.println();
        System.out.println("Digite o nome da sua comunidade: ");
        comunidade_escolha = input.nextLine();
        for (w = 0; w < Comunidades.size(); w++) {
            if (Comunidades.get(w).getNome_comunidade().equals(comunidade_escolha) && (Comunidades.get(w).getAdmin().equals(user.getLogin()))) {
                System.out.println("Esses são os pedidos pendentes:");
                if (Comunidades.get(w).getPedidos().size() > 0) {
                    for (v = 0; v < Comunidades.get(w).getPedidos().size(); v++) {
                        System.out.println(Comunidades.get(w).getPedidos().get(v));
                    }
                    System.out.println("Digite o nome de quem você quer adicionar a comunidade:");
                    novo_membro = input.nextLine();
                    Comunidades.get(w).getMembros().add(novo_membro);
                    local = user.search_user(Usuarios, novo_membro);
                    Usuarios.get(local).getComunidades_part().add(comunidade_escolha);
                    for (y = 0; y < Comunidades.get(w).getPedidos().size(); y++) {
                        if (Comunidades.get(w).getPedidos().get(y).equals(novo_membro)) {
                            Comunidades.get(w).getPedidos().remove(y);
                        }
                    }
                    System.out.println("Adicionado com sucesso!!!");
                    control62 = 1;
                } else {
                    System.out.println("Não há pedidos pendentes!!!");
                    System.out.println();
                }
            } else if (w == Comunidades.size() - 1 && (control62 == 0)) {
                System.out.println("Nome da comunidade incorreto, ou você não é o proprietário desta comunidade");
            }
        }
        System.out.print("Deseja ver a lista de membros da sua comunidade?\n Sim: Digite 1\n Não: Digite 0\nResp: ");
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
                System.out.println("Foi digitado um elemento diferente de um numero! Tente novamente...\nDeseja ver a lista de membros da sua comunidade?\n Sim: Digite 1\n Não: Digite 0\nResp: ");
            }
        }   
        cont_aux = 0;
        System.out.println();
        if (resp == 1) {
            for (w = 0; w < user.getComunidade().getMembros().size(); w++) {
                System.out.println(user.getComunidade().getMembros().get(w));
            }
        }
        return Comunidades;
    }
    
    public java.util.ArrayList<Usuario> create_comunidade(Comunidade c, Usuario user, java.util.ArrayList<Usuario> Usuarios)
    {
        int local;
        System.out.println("Digite nome da Comunidade que deseja criar: ");
        c.setNome_comunidade(input.nextLine());
        System.out.println("Digite a descrição da Comunidade: ");
        c.setDescricao(input.nextLine());
        System.out.println("Digite o status da sua comunidade (publico ou privado):");
        c.setStatus(input.nextLine());
        c.setAdmin(user.getLogin());
        c.getMembros().add(user.getLogin());

        user.setComunidade(c);
        user.getComunidades_part().add(c.getNome_comunidade());
        
        local = user.search_user(Usuarios, user.getLogin());
        Usuarios.set(local, user);
        
        return Usuarios;
    }
    
    public java.util.ArrayList<Comunidade> mandar_msg_comunidade(java.util.ArrayList<Comunidade> Comunidades, Usuario user)
    {
        String name_comunidade;
        int q, i, j, control41 = 0, control42 = 0;
        System.out.println("Comunidades existentes:");
        for (q = 0; q < Comunidades.size(); q++) {
            System.out.println(Comunidades.get(q).getNome_comunidade());
        }
        System.out.println();
        System.out.println("Digite o nome da comunidade que deseja enviar mensagem: ");
        name_comunidade = input.nextLine();
        for (i = 0; i < Comunidades.size(); i++) {
            if (Comunidades.get(i).getNome_comunidade().equals(name_comunidade)) {
                for (j = 0; j < Comunidades.get(i).getMembros().size(); j++) {
                    if (Comunidades.get(i).getMembros().get(j).equals(user.getLogin())) {
                        System.out.println("Digite a mensagem que deseja enviar, siga este formato (SEU_LOGIN: Mensagem): ");
                        MsgComunidade msg = new MsgComunidade();
                        msg.setNome_user(user.getLogin());
                        msg.setMensagem(input.nextLine());
                        Comunidades.get(i).getMensagens().add(msg);
                        System.out.println("Mensagem enviada com sucessso!!!");
                        control42 = 1;
                    } else if ((j == Comunidades.get(i).getMembros().size() - 1) && (control42 == 0)) {
                        System.out.println("Você não é membro desta comunidade");
                    }
                }
                control41 = 1;
            } else if ((i == Comunidades.size() - 1) && (control41 == 0)) {
                System.out.println("Comunidade não encontrada, não existe ou você pode ter digitado incorretamente.");
            }
        }
        return Comunidades;
    }
    
    public void checar_msg_comunidade(java.util.ArrayList<Comunidade> Comunidades, Usuario user)
    {
        int f, q, i, j, control41 = 0, control42 = 0;
        System.out.println("Comunidades existentes:");
        for (q = 0; q < Comunidades.size(); q++) {
            System.out.println(Comunidades.get(q).getNome_comunidade());
        }
        System.out.println();
        System.out.println("Digite o nome da comunidade que deseja checar as mensagens: ");
        nome_comunidade = input.nextLine();
        for (i = 0; i < Comunidades.size(); i++) {
            if (Comunidades.get(i).getNome_comunidade().equals(nome_comunidade)) {
                for (j = 0; j < Comunidades.get(i).getMembros().size(); j++) {
                    if (Comunidades.get(i).getMembros().get(j).equals(user.getLogin())) {
                        for (f = 0; f < Comunidades.get(i).getMensagens().size(); f++) {
                            System.out.println(Comunidades.get(i).getMensagens().get(f).getMensagem());
                            control42 = 1;
                        }
                    } else if ((j == Comunidades.get(i).getMembros().size() - 1) && (control42 == 0)) {
                        System.out.println("Você não é membro desta comunidade");
                    }
                }
                control41 = 1;
            } else if ((i == Comunidades.size() - 1) && (control41 == 0)) {
                System.out.println("Comunidade não encontrada, não existe ou você digitou incorretamente.");
            }
        }
    }
    
    public ArrayList<MsgComunidade> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<MsgComunidade> mensagens) {
        this.mensagens = mensagens;
    }

    public ArrayList<String> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<String> pedidos) {
        this.pedidos = pedidos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome_comunidade() {
        return nome_comunidade;
    }

    public void setNome_comunidade(String nome_comunidade) {
        this.nome_comunidade = nome_comunidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public ArrayList<String> getMembros() {
        return Membros;
    }

    public void setMembros(ArrayList<String> Membros) {
        this.Membros = Membros;
    }
}
