package com.mygdx.uspace1.gamenet;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class GameNet {
    public Client client;
    public Kryo kryo;

    // Init networking
    public void initNet () {
        client = new Client();
        kryo = client.getKryo();
        kryo.register(SRq.class);
        kryo.register(LGq.class);
        client.start();
        try {
            client.connect(6000, "localhost", 54555, 54777);
            System.out.println("Connected to server!");
        } catch (Exception e) {
            System.err.println("Failed to connect to server!");
        }
        client.addListener(new Listener() {
            @Override
            public void received(Connection connection, Object object) {
                if(object instanceof SRq) {
                    //Gdx.app.log("Client", ((SRq) object).id);
                    System.out.println("Received: "+((SRq) object).id);
                }
                if(object instanceof LGq) {
                    //Gdx.app.log("Client", ((SRq) object).id);
                    System.out.println("Received: "+((LGq) object).id);
                }
            }
        });
    }
}
