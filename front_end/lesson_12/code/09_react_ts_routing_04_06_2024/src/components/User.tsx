import { Component } from "react";
import { IUserJson } from "./UserList";

// rce
export class User extends Component<{person: IUserJson}> {
  render() {
    const { name, email, address: { city }, company: { name: companyName } } = this.props.person;
    return (
      <div className="card col-3 m-2">
        <div className="card-body">
          <h5 className="card-title">{name}</h5>
          <h6 className="card-subtitle mb-2 text-muted">{email}</h6>
          <p className="card-text">{city}</p>
          <p className="card-text"><small className="text-muted">{companyName}</small></p>
        </div>
      </div>
    );
  }
}

export default User;
