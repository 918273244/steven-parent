package com.steven.patten.factory;

/**
 * Created by Steven on 2017/5/26.
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        //定义一种人
        T human = null;

        try {
            human = (T) Class.forName(c.getName()).newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return (T) human;
    }
}
