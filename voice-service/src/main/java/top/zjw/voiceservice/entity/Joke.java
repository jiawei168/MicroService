package top.zjw.voiceservice.entity;

import lombok.Data;

@Data
public class Joke {
    private boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private Flags flags;
    private int id;
    private boolean safe;
    private String lang;

    // Getters and Setters
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        if ("twopart".equals(type)) {
            return setup + "\n" + delivery;
        } else {
            return setup;
        }
    }

    // Flags 内部类
    public static class Flags {
        private boolean nsfw;
        private boolean religious;
        private boolean political;
        private boolean racist;
        private boolean sexist;
        private boolean explicit;

        // Getters and Setters
        public boolean isNsfw() {
            return nsfw;
        }

        public void setNsfw(boolean nsfw) {
            this.nsfw = nsfw;
        }

        public boolean isReligious() {
            return religious;
        }

        public void setReligious(boolean religious) {
            this.religious = religious;
        }

        public boolean isPolitical() {
            return political;
        }

        public void setPolitical(boolean political) {
            this.political = political;
        }

        public boolean isRacist() {
            return racist;
        }

        public void setRacist(boolean racist) {
            this.racist = racist;
        }

        public boolean isSexist() {
            return sexist;
        }

        public void setSexist(boolean sexist) {
            this.sexist = sexist;
        }

        public boolean isExplicit() {
            return explicit;
        }

        public void setExplicit(boolean explicit) {
            this.explicit = explicit;
        }
    }
}