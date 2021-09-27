package Conversores;

public class FactoryConversor {

    public AbstractConversor fabricarConversor(Class<? extends Object> t) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nomeDaClasse = "";
        if (t.isAnnotationPresent(Conversor.class)) {
            Conversor c = t.getAnnotation(Conversor.class);
            if (!c.nome().isEmpty()) {
                nomeDaClasse = c.nome();
            }
        } else {
            nomeDaClasse = "org.spe.db.conversores.Conversor" + t.getSimpleName();
        }
        return (AbstractConversor) Class.forName(nomeDaClasse).newInstance();
    }
}
