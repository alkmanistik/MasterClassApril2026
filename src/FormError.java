public enum FormError {
    NAME_ERROR("Ошибка в поле 'Имя'"),
    AGE_ERROR("Ошибка в поле 'Возраст'"),
    GENDER_ERROR("Ошибка в поле 'Пол'"),
    PHONE_ERROR("Ошибка в поле 'Телефон'"),
    EMAIL_ERROR("Ошибка в поле 'Почта'");

    private final String title;

    FormError(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
