package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.UserResponseCallback;
import ru.mirea.azbukindu.domain.repository.UsersRepository;

public class GetUserInfoUseCase {

    private UsersRepository usersRepository;

    public GetUserInfoUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(String id, UserResponseCallback userResponseCallback) {
        usersRepository.getUserInfo(id, userResponseCallback);
    }
}
