package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.UserResponseCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class GetUserIdUseCase {

    private UsersRepository usersRepository;

    public GetUserIdUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String execute(){
        return usersRepository.getUserId();
    }
}
