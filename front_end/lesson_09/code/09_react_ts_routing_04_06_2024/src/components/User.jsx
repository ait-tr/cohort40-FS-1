import React, { Component } from "react";

// rce
export class User extends Component {
  render() {
    const { name, email, address: { city }, company: { name: companyName } } = this.props.person;
    return (
      <div className="border my-5">
        <div>{name}</div>
        <div>{email}</div>
        <div>{city}</div>
        <div>{companyName}</div>
      </div>
    );
  }
}

export default User;
